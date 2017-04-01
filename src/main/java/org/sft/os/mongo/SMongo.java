package org.sft.os.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.sft.os.mongo.databases.SDatabase;

/**
 *
 */
public class SMongo extends MongoClient {

    @Override
    public MongoDatabase getDatabase(String databaseName) {
        return super.getDatabase(databaseName);
    }

    public SDatabase getSDatabase(String databaseName) {
        return null;
    }
}
