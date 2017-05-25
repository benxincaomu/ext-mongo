package org.sft.os.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoDriverInformation;
import org.sft.os.mongo.databases.DatabaseE;

import java.util.List;

/**
 *
 */
public class MongoE extends MongoClient {

    public MongoE() {
    }

    public MongoE(String host) {
        super(host);
    }

    public MongoE(String host, MongoClientOptions options) {
        super(host, options);
    }

    public MongoE(String host, int port) {
        super(host, port);
    }

    public MongoE(ServerAddress addr) {
        super(addr);
    }

    public MongoE(ServerAddress addr, List<MongoCredential> credentialsList) {
        super(addr, credentialsList);
    }

    public MongoE(ServerAddress addr, MongoClientOptions options) {
        super(addr, options);
    }

    public MongoE(ServerAddress addr, List<MongoCredential> credentialsList, MongoClientOptions options) {
        super(addr, credentialsList, options);
    }

    public MongoE(List<ServerAddress> seeds) {
        super(seeds);
    }

    public MongoE(List<ServerAddress> seeds, List<MongoCredential> credentialsList) {
        super(seeds, credentialsList);
    }

    public MongoE(List<ServerAddress> seeds, MongoClientOptions options) {
        super(seeds, options);
    }

    public MongoE(List<ServerAddress> seeds, List<MongoCredential> credentialsList, MongoClientOptions options) {
        super(seeds, credentialsList, options);
    }

    public MongoE(MongoClientURI uri) {
        super(uri);
    }

    public MongoE(MongoClientURI uri, MongoDriverInformation mongoDriverInformation) {
        super(uri, mongoDriverInformation);
    }

    public MongoE(ServerAddress addr, List<MongoCredential> credentialsList, MongoClientOptions options,
                  MongoDriverInformation mongoDriverInformation) {
        super(addr, credentialsList, options, mongoDriverInformation);
    }

    public MongoE(List<ServerAddress> seeds, List<MongoCredential> credentialsList, MongoClientOptions options,
                  MongoDriverInformation mongoDriverInformation) {
        super(seeds, credentialsList, options, mongoDriverInformation);
    }

    /**
     * 获取扩展databaseE
     *
     * @param databaseName 数据库名称
     * @return DatabaseE
     */
    public DatabaseE getDataBaseE(String databaseName) {
        return new DatabaseEImpl(getDatabase(databaseName));
    }

}
