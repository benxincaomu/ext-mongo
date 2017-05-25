package org.sft.os.mongo.codecs;

import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @param <T> 要存储或读取的对象类型
 * @author sunft
 */
public class MongoCodec<T> implements Codec<T> {
    /**
     * 要存储或读取的对象类型
     */
    private Class<T> clazz;

    public MongoCodec(Class<T> clazz) {
        if (List.class.isAssignableFrom(clazz)) {
            throw new AssertionError(String.format("无效的类型：%s", clazz.getName()));
        }
        this.clazz = clazz;
    }

    @Override
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        return (T) decodeObject(reader, decoderContext, clazz);
    }

    /**
     * 反序列化
     *
     * @param reader         reader
     * @param decoderContext decoderContext
     * @param clazz          对应的类型
     * @return clazz类型的的实例
     */
    private Object decodeObject(BsonReader reader, DecoderContext decoderContext, Class clazz) {
        Object object = null;
        reader.readStartDocument();
        try {
            object = clazz.newInstance();
            BsonType type;
            while ((type = reader.readBsonType()) != BsonType.END_OF_DOCUMENT) {
                String name = reader.readName();
                Field field = null;
                Object value = null;
                boolean isDefault = false;
                try {
                    switch (type) {
                        case ARRAY:
                            List list = new ArrayList();
                            reader.readStartArray();
                            field = clazz.getDeclaredField(name);
                            field.setAccessible(true);
                            ParameterizedType pt = (ParameterizedType) field.getGenericType();
                            Class cla = (Class) pt.getActualTypeArguments()[0];
                            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                                reader.getCurrentBsonType();
                                Object obj;
                                if (Integer.class.isAssignableFrom(cla) || int.class.isAssignableFrom(cla)) {
                                    obj = reader.readInt32();
                                } else if (Long.class.isAssignableFrom(cla) || Long.class.isAssignableFrom(cla)) {
                                    obj = reader.readInt64();
                                } else if (Double.class.isAssignableFrom(cla) || double.class.isAssignableFrom(cla)) {
                                    obj = reader.readDouble();
                                } else if (Boolean.class.isAssignableFrom(cla) || boolean.class.isAssignableFrom(cla)) {
                                    obj = reader.readDouble();
                                } else if (Date.class.isAssignableFrom(cla)) {
                                    obj = new Date(reader.readDateTime());
                                } else if (String.class.isAssignableFrom(cla)) {
                                    obj = reader.readString();
                                } else {
                                    obj = decodeObject(reader, decoderContext, cla);
                                }
                                list.add(obj);
                            }
                            reader.readEndArray();
                            value = list;
                            break;
                        case DOUBLE:
                            value = reader.readDouble();

                            break;
                        case STRING:
                            value = reader.readString();
                            break;
                        case BOOLEAN:
                            value = reader.readBoolean();
                            break;
                        case DATE_TIME:
                            value = new Date(reader.readDateTime());
                            break;
                        case INT32:
                            value = reader.readInt32();
                            break;
                        case INT64:
                            value = reader.readInt64();
                            break;
                        case OBJECT_ID:
                            isDefault = true;
                            reader.readObjectId();
                            break;
                        case DOCUMENT:
                            value = decodeObject(reader, decoderContext, field.getType());
                            break;
                        default:
                            isDefault = true;
                            break;
                    }
                    if (!isDefault) { //默认则不执行设置，避免不必要的抛出异常
                        field = clazz.getDeclaredField(name);
                        field.setAccessible(true);
                        field.set(object, value);
                        field.setAccessible(false);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }


            }

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        reader.readEndDocument();
        return object;
    }

    @Override
    public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
        encodeObject(writer, value, encoderContext);
    }

    /**
     * 遍历属性，进行相应的类型写入
     * 目前做一些常用类型的判断，如有需要可以自行添加
     *
     * @param writer         writer
     * @param value          要写入的对象
     * @param encoderContext encoderContext
     */
    private void encodeObject(BsonWriter writer, Object value, EncoderContext encoderContext) {
        writer.writeStartDocument();
        if (Map.class.isAssignableFrom(value.getClass())) {
            Map<String, Object> map = (Map<String, Object>) value;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                writer.writeName(entry.getKey());
                writeValue(writer, entry.getValue(), encoderContext);
            }
        } else {
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (value.getClass().isAssignableFrom(field.getType())) {
                    continue;
                }
                field.setAccessible(true);
                try {
                    writer.writeName(field.getName());
                    writeValue(writer, field.get(value), encoderContext);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.writeEndDocument();
    }

    /**
     * 将属性值写入数据库
     *
     * @param writer         writer
     * @param obj            属性值
     * @param encoderContext encoderContext
     */
    private void writeValue(BsonWriter writer, Object obj, EncoderContext encoderContext) {
        if (Integer.class.isAssignableFrom(obj.getClass()) || int.class.isAssignableFrom(obj.getClass())) {
            writer.writeInt32((int) obj);
        } else if (Long.class.isAssignableFrom(obj.getClass()) || Long.class.isAssignableFrom(obj.getClass())) {
            writer.writeInt64((long) obj);
        } else if (Double.class.isAssignableFrom(obj.getClass()) || double.class.isAssignableFrom(obj.getClass())) {
            writer.writeDouble((double) obj);
        } else if (Boolean.class.isAssignableFrom(obj.getClass()) || boolean.class.isAssignableFrom(obj.getClass())) {
            writer.writeBoolean((boolean) obj);
        } else if (Date.class.isAssignableFrom(obj.getClass())) {
            writer.writeDateTime((long) obj);
        } else if (String.class.isAssignableFrom(obj.getClass())) {
            writer.writeString((String) obj);
        } else if (int[].class.isAssignableFrom(obj.getClass())) {
            int[] arr = (int[]) obj;
            writer.writeStartArray();
            for (int i : arr) {
                writer.writeInt32(i);
            }
            writer.writeEndArray();
        } else if (long[].class.isAssignableFrom(obj.getClass())) {
            long[] arr = (long[]) obj;
            writer.writeStartArray();
            for (long i : arr) {
                writer.writeInt64(i);
            }
            writer.writeEndArray();
        } else if (double[].class.isAssignableFrom(obj.getClass())) {
            double[] arr = (double[]) obj;
            writer.writeStartArray();
            for (double i : arr) {
                writer.writeDouble(i);
            }
            writer.writeEndArray();
        } else if (boolean[].class.isAssignableFrom(obj.getClass())) {
            boolean[] arr = (boolean[]) obj;
            writer.writeStartArray();
            for (boolean i : arr) {
                writer.writeBoolean(i);
            }
            writer.writeEndArray();
        } else if (List.class.isAssignableFrom(obj.getClass())) {
            List list = (List) obj;
            writer.writeStartArray();
            for (Object item : list) {
                writeValue(writer, item, encoderContext);
            }
            writer.writeEndArray();
        } else if (Map.class.isAssignableFrom(obj.getClass())) {
            Map<String, Object> map = (Map<String, Object>) obj;
            writer.writeStartDocument();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                writer.writeName(entry.getKey());
                encodeObject(writer, obj, encoderContext);
            }
            writer.writeEndDocument();
        } else {
            encodeObject(writer, obj, encoderContext);
        }
    }

    @Override
    public Class<T> getEncoderClass() {
        return clazz;
    }


}
