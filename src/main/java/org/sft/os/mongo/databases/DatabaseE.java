package org.sft.os.mongo.databases;

import com.mongodb.client.MongoDatabase;
import org.sft.os.mongo.collections.CollectionE;

/**
 * @author sunft
 *         扩展MongoDatabase
 */
public interface DatabaseE extends MongoDatabase {
    /**
     * @param collectionName 集合名
     * @param clazz          Class<TDocument>
     * @param <TDocument>    collection中存储的类型
     * @return CollectionE<TDocument>
     */
    <TDocument> CollectionE<TDocument> getCollectionE(String collectionName, Class<TDocument> clazz);
}
