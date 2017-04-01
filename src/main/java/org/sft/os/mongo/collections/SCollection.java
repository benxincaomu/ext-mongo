package org.sft.os.mongo.collections;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;

import java.util.List;

/**
 * @author sunft
 */
public interface SCollection<TDocument> extends MongoCollection<TDocument> {
    /**
     * 写入一条记录
     *
     * @param t 要写入的对象
     * @return 写入结果
     */
    WriteResult insertSingle(TDocument t);


    /**
     * 批量写入
     *
     * @param tDocuments 要写入的对象集合
     * @return 写入结果
     */
    WriteResult insertMore(List<TDocument> tDocuments);

    /**
     * 根据条件查找唯一记录
     *
     * @param query 查询条件
     * @return
     */
    TDocument findSingle(final DBObject query);


}
