package org.sft.os.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.sft.os.mongo.databases.DatabaseE;

/**
 *
 */
public class MongoE extends MongoClient {

    @Override
    public MongoDatabase getDatabase(String databaseName) {
        return super.getDatabase(databaseName);
    }

    public DatabaseE getSDatabase(String databaseName) {
        return null;
    }
}
