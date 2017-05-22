package org.sft.os.mongo.databases;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.CreateViewOptions;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.sft.os.mongo.collections.CollectionE;
import org.sft.os.mongo.collections.CollectionEImpl;

import java.util.List;


public class DatabaseEImpl implements DatabaseE {
    private MongoDatabase mongoDatabase;

    @Override
    public <TDocument> CollectionE<TDocument> getSCollection(String collectionName, Class<TDocument> clazz) {
        return new CollectionEImpl<TDocument>(mongoDatabase.getCollection(collectionName, clazz), clazz);
    }

    @Override
    public String getName() {
        return mongoDatabase.getName();
    }

    @Override
    public CodecRegistry getCodecRegistry() {
        return mongoDatabase.getCodecRegistry();
    }

    @Override
    public ReadPreference getReadPreference() {
        return mongoDatabase.getReadPreference();
    }

    @Override
    public WriteConcern getWriteConcern() {
        return mongoDatabase.getWriteConcern();
    }

    @Override
    public ReadConcern getReadConcern() {
        return mongoDatabase.getReadConcern();
    }

    @Override
    public MongoDatabase withCodecRegistry(CodecRegistry codecRegistry) {
        return mongoDatabase.withCodecRegistry(codecRegistry);
    }

    @Override
    public MongoDatabase withReadPreference(ReadPreference readPreference) {
        return mongoDatabase.withReadPreference(readPreference);
    }

    @Override
    public MongoDatabase withWriteConcern(WriteConcern writeConcern) {
        return mongoDatabase.withWriteConcern(writeConcern);
    }

    @Override
    public MongoDatabase withReadConcern(ReadConcern readConcern) {
        return mongoDatabase.withReadConcern(readConcern);
    }

    @Override
    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoDatabase.getCollection(collectionName);
    }

    @Override
    public <TDocument> MongoCollection<TDocument> getCollection(String collectionName, Class<TDocument> tDocumentClass) {
        return mongoDatabase.getCollection(collectionName, tDocumentClass);
    }

    @Override
    public Document runCommand(Bson command) {
        return mongoDatabase.runCommand(command);
    }

    @Override
    public Document runCommand(Bson command, ReadPreference readPreference) {
        return mongoDatabase.runCommand(command, readPreference);
    }

    @Override
    public <TResult> TResult runCommand(Bson command, Class<TResult> tResultClass) {
        return mongoDatabase.runCommand(command, tResultClass);
    }

    @Override
    public <TResult> TResult runCommand(Bson command, ReadPreference readPreference, Class<TResult> tResultClass) {
        return mongoDatabase.runCommand(command, readPreference, tResultClass);
    }

    @Override
    public void drop() {
        mongoDatabase.drop();
    }

    @Override
    public MongoIterable<String> listCollectionNames() {
        return mongoDatabase.listCollectionNames();
    }

    @Override
    public ListCollectionsIterable<Document> listCollections() {
        return mongoDatabase.listCollections();
    }

    @Override
    public <TResult> ListCollectionsIterable<TResult> listCollections(Class<TResult> tResultClass) {
        return mongoDatabase.listCollections(tResultClass);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoDatabase.createCollection(collectionName);
    }

    @Override
    public void createCollection(String collectionName, CreateCollectionOptions createCollectionOptions) {
        mongoDatabase.createCollection(collectionName, createCollectionOptions);
    }

    @Override
    public void createView(String viewName, String viewOn, List<? extends Bson> pipeline) {
        mongoDatabase.createView(viewName, viewOn, pipeline);
    }

    @Override
    public void createView(String viewName, String viewOn, List<? extends Bson> pipeline, CreateViewOptions createViewOptions) {
        mongoDatabase.createView(viewName, viewOn, pipeline, createViewOptions);
    }
}
