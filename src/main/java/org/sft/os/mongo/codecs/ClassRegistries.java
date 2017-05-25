package org.sft.os.mongo.codecs;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunft
 *         <p>
 *         存储Registries
 */
public final class ClassRegistries {

    /**
     * class为键，对应的CodecRegistry为值
     */
    private static Map<Class, CodecRegistry> codecRegistryMap = new HashMap<>();

    private ClassRegistries() {
        super();
    }

    /**
     * 获取CodecRegistry
     *
     * @param clazz 类名
     * @param <T>   类
     * @return CodecRegistry
     */
    public static <T> CodecRegistry getCodecRegistry(Class<T> clazz) {
        CodecRegistry codecRegistry = codecRegistryMap.get(clazz);
        if (codecRegistry == null) {
            codecRegistry = CodecRegistries.fromCodecs(new MongoCodec<T>(clazz));
            codecRegistryMap.put(clazz, codecRegistry);
        }
        return codecRegistry;

    }
}
