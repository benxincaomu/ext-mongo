package org.sft.os.mongo.collections;

import com.mongodb.*;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import java.util.List;

/**
 * @author sunft
 */
public class SCollectionImpl<TDocument> implements SCollection<TDocument> {
    private MongoCollection<TDocument> mongoCollection;

    public WriteResult insertSingle(TDocument t) {
        return null;
    }

    public WriteResult insertMore(List<TDocument> tDocuments) {
        return null;
    }

    public TDocument findSingle(DBObject query) {
        return null;
    }

    public MongoNamespace getNamespace() {
        return mongoCollection.getNamespace();
    }

    public Class getDocumentClass() {
        return mongoCollection.getDocumentClass();
    }

    public CodecRegistry getCodecRegistry() {
        return mongoCollection.getCodecRegistry();
    }

    public ReadPreference getReadPreference() {
        return mongoCollection.getReadPreference();
    }

    public WriteConcern getWriteConcern() {
        return mongoCollection.getWriteConcern();
    }

    public ReadConcern getReadConcern() {
        return mongoCollection.getReadConcern();
    }

    public MongoCollection withDocumentClass(Class clazz) {
        return mongoCollection.withDocumentClass(clazz);
    }

    public MongoCollection withCodecRegistry(CodecRegistry codecRegistry) {
        return mongoCollection.withCodecRegistry(codecRegistry);
    }

    public MongoCollection withReadPreference(ReadPreference readPreference) {
        return mongoCollection.withReadPreference(readPreference);
    }

    public MongoCollection withWriteConcern(WriteConcern writeConcern) {
        return mongoCollection.withWriteConcern(writeConcern);
    }

    public MongoCollection withReadConcern(ReadConcern readConcern) {
        return mongoCollection.withReadConcern(readConcern);
    }

    public long count() {
        return mongoCollection.count();
    }

    public long count(Bson filter) {
        return mongoCollection.count(filter);
    }

    public long count(Bson filter, CountOptions options) {
        return mongoCollection.count(filter, options);
    }

    public DistinctIterable distinct(String fieldName, Class aClass) {
        return mongoCollection.distinct(fieldName, aClass);
    }

    public DistinctIterable distinct(String fieldName, Bson filter, Class aClass) {
        return mongoCollection.distinct(fieldName, filter, aClass);
    }

    public FindIterable find() {
        return mongoCollection.find();
    }

    public FindIterable find(Class aClass) {
        return mongoCollection.find(aClass);
    }

    public FindIterable find(Bson filter) {
        return mongoCollection.find(filter);
    }

    public FindIterable find(Bson filter, Class aClass) {
        return mongoCollection.find(filter, aClass);
    }

    public AggregateIterable aggregate(List pipeline) {
        return mongoCollection.aggregate(pipeline);
    }

    public AggregateIterable aggregate(List pipeline, Class aClass) {
        return mongoCollection.aggregate(pipeline, aClass);
    }

    public MapReduceIterable mapReduce(String mapFunction, String reduceFunction) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction);
    }

    public MapReduceIterable mapReduce(String mapFunction, String reduceFunction, Class aClass) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction, aClass);
    }

    public BulkWriteResult bulkWrite(List requests) {
        return mongoCollection.bulkWrite(requests);
    }

    public BulkWriteResult bulkWrite(List requests, BulkWriteOptions options) {
        return null;
    }

    public void insertOne(TDocument tDocument) {
        mongoCollection.insertOne(tDocument);
    }

    public void insertOne(TDocument tDocument, InsertOneOptions options) {
        mongoCollection.insertOne(tDocument, options);
    }

    public void insertMany(List<? extends TDocument> tDocuments) {
        mongoCollection.insertMany(tDocuments);
    }

    public void insertMany(List<? extends TDocument> tDocuments, InsertManyOptions options) {
        mongoCollection.insertMany(tDocuments, options);
    }

    public DeleteResult deleteOne(Bson filter) {
        return mongoCollection.deleteOne(filter);
    }

    public DeleteResult deleteOne(Bson filter, DeleteOptions options) {
        return mongoCollection.deleteOne(filter, options);
    }

    public DeleteResult deleteMany(Bson filter) {
        return mongoCollection.deleteMany(filter);
    }

    public DeleteResult deleteMany(Bson filter, DeleteOptions options) {
        return mongoCollection.deleteMany(filter, options);
    }

    public UpdateResult replaceOne(Bson filter, TDocument replacement) {
        return mongoCollection.replaceOne(filter, replacement);
    }

    public UpdateResult replaceOne(Bson filter, TDocument replacement, UpdateOptions updateOptions) {
        return mongoCollection.replaceOne(filter, replacement, updateOptions);
    }

    public UpdateResult updateOne(Bson filter, Bson update) {
        return mongoCollection.updateOne(filter, update);
    }

    public UpdateResult updateOne(Bson filter, Bson update, UpdateOptions updateOptions) {
        return mongoCollection.updateOne(filter, update, updateOptions);
    }

    public UpdateResult updateMany(Bson filter, Bson update) {
        return mongoCollection.updateMany(filter, update);
    }

    public UpdateResult updateMany(Bson filter, Bson update, UpdateOptions updateOptions) {
        return mongoCollection.updateMany(filter, update, updateOptions);
    }

    public TDocument findOneAndDelete(Bson filter) {
        return mongoCollection.findOneAndDelete(filter);
    }

    public TDocument findOneAndDelete(Bson filter, FindOneAndDeleteOptions options) {
        return mongoCollection.findOneAndDelete(filter, options);
    }

    public TDocument findOneAndReplace(Bson filter, TDocument replacement) {
        return mongoCollection.findOneAndReplace(filter, replacement);
    }

    public TDocument findOneAndReplace(Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        return mongoCollection.findOneAndReplace(filter, replacement, options);
    }

    public TDocument findOneAndUpdate(Bson filter, Bson update) {
        return mongoCollection.findOneAndUpdate(filter, update);
    }

    public TDocument findOneAndUpdate(Bson filter, Bson update, FindOneAndUpdateOptions options) {
        return mongoCollection.findOneAndUpdate(filter, update, options);
    }

    public void drop() {
        mongoCollection.drop();
    }

    public String createIndex(Bson keys) {
        return mongoCollection.createIndex(keys);
    }

    public String createIndex(Bson keys, IndexOptions indexOptions) {
        return mongoCollection.createIndex(keys, indexOptions);
    }

    public List<String> createIndexes(List<IndexModel> indexes) {
        return mongoCollection.createIndexes(indexes);
    }

    public ListIndexesIterable<Document> listIndexes() {
        return mongoCollection.listIndexes();
    }

    public <TResult> ListIndexesIterable<TResult> listIndexes(Class<TResult> tResultClass) {
        return mongoCollection.listIndexes(tResultClass);
    }

    public void dropIndex(String indexName) {
        mongoCollection.dropIndex(indexName);
    }

    public void dropIndex(Bson keys) {
        mongoCollection.dropIndex(keys);
    }

    public void dropIndexes() {
        mongoCollection.dropIndexes();
    }

    public void renameCollection(MongoNamespace newCollectionNamespace) {
        mongoCollection.renameCollection(newCollectionNamespace);
    }

    public void renameCollection(MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        mongoCollection.renameCollection(newCollectionNamespace, renameCollectionOptions);
    }
}
