package org.sft.os.mongo;

import com.mongodb.*;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.sft.os.mongo.collections.CollectionE;

import java.util.List;

/**
 * @author sunft
 * @param <TDocument> 泛型，collection的存储类型
 */
public class CollectionEImpl<TDocument> implements CollectionE<TDocument> {
    /**
     * 基于MongoCollection做实现
     */
    private MongoCollection<TDocument> mongoCollection;

    public CollectionEImpl(MongoCollection<TDocument> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    @Override
    public WriteResult insertSingle(TDocument t) {
        return null;
    }

    @Override
    public WriteResult insertMore(List<TDocument> tDocuments) {
        return null;
    }

    @Override
    public TDocument findSingle(DBObject query) {
        return null;
    }

    @Override
    public MongoNamespace getNamespace() {
        return mongoCollection.getNamespace();
    }

    @Override
    public Class<TDocument> getDocumentClass() {
        return mongoCollection.getDocumentClass();
    }

    @Override
    public CodecRegistry getCodecRegistry() {
        return mongoCollection.getCodecRegistry();
    }

    @Override
    public ReadPreference getReadPreference() {
        return mongoCollection.getReadPreference();
    }

    @Override
    public WriteConcern getWriteConcern() {
        return mongoCollection.getWriteConcern();
    }

    @Override
    public ReadConcern getReadConcern() {
        return mongoCollection.getReadConcern();
    }

    @Override
    public <NewTDocument> MongoCollection<NewTDocument> withDocumentClass(Class<NewTDocument> clazz) {
        return mongoCollection.withDocumentClass(clazz);
    }

    @Override
    public MongoCollection<TDocument> withCodecRegistry(CodecRegistry codecRegistry) {
        return mongoCollection.withCodecRegistry(codecRegistry);
    }

    @Override
    public MongoCollection<TDocument> withReadPreference(ReadPreference readPreference) {
        return mongoCollection.withReadPreference(readPreference);
    }

    @Override
    public MongoCollection<TDocument> withWriteConcern(WriteConcern writeConcern) {
        return mongoCollection.withWriteConcern(writeConcern);
    }

    @Override
    public MongoCollection<TDocument> withReadConcern(ReadConcern readConcern) {
        return mongoCollection.withReadConcern(readConcern);
    }

    @Override
    public long count() {
        return mongoCollection.count();
    }

    @Override
    public long count(Bson filter) {
        return mongoCollection.count(filter);
    }

    @Override
    public long count(Bson filter, CountOptions options) {
        return mongoCollection.count(filter, options);
    }

    @Override
    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Class<TResult> tResultClass) {
        return mongoCollection.distinct(fieldName, tResultClass);
    }

    @Override
    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Bson filter, Class<TResult> aClass) {
        return mongoCollection.distinct(fieldName, filter, aClass);
    }

    @Override
    public FindIterable<TDocument> find() {
        return mongoCollection.find();
    }

    @Override
    public <TResult> FindIterable<TResult> find(Class<TResult> aClass) {
        return mongoCollection.find(aClass);
    }

    @Override
    public FindIterable<TDocument> find(Bson filter) {
        return mongoCollection.find(filter);
    }

    @Override
    public <TResult> FindIterable<TResult> find(Bson filter, Class<TResult> tResultClass) {
        return mongoCollection.find(filter, tResultClass);
    }

    @Override
    public AggregateIterable<TDocument> aggregate(List<? extends Bson> pipeline) {
        return mongoCollection.aggregate(pipeline);
    }

    @Override
    public <TResult> AggregateIterable<TResult> aggregate(List<? extends Bson> pipeline, Class<TResult> tResultClass) {
        return mongoCollection.aggregate(pipeline, tResultClass);
    }

    @Override
    public MapReduceIterable<TDocument> mapReduce(String mapFunction, String reduceFunction) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction);
    }

    @Override
    public <TResult> MapReduceIterable<TResult> mapReduce(String mapFunction, String reduceFunction, Class<TResult> tResultClass) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction, tResultClass);
    }

    @Override
    public BulkWriteResult bulkWrite(List<? extends WriteModel<? extends TDocument>> requests) {
        return mongoCollection.bulkWrite(requests);
    }

    @Override
    public BulkWriteResult bulkWrite(List requests, BulkWriteOptions options) {
        return null;
    }

    @Override
    public void insertOne(TDocument tDocument) {
        mongoCollection.insertOne(tDocument);
    }

    @Override
    public void insertOne(TDocument tDocument, InsertOneOptions options) {
        mongoCollection.insertOne(tDocument, options);
    }

    @Override
    public void insertMany(List<? extends TDocument> tDocuments) {
        mongoCollection.insertMany(tDocuments);
    }

    @Override
    public void insertMany(List<? extends TDocument> tDocuments, InsertManyOptions options) {
        mongoCollection.insertMany(tDocuments, options);
    }

    @Override
    public DeleteResult deleteOne(Bson filter) {
        return mongoCollection.deleteOne(filter);
    }

    @Override
    public DeleteResult deleteOne(Bson filter, DeleteOptions options) {
        return mongoCollection.deleteOne(filter, options);
    }

    @Override
    public DeleteResult deleteMany(Bson filter) {
        return mongoCollection.deleteMany(filter);
    }

    @Override
    public DeleteResult deleteMany(Bson filter, DeleteOptions options) {
        return mongoCollection.deleteMany(filter, options);
    }

    @Override
    public UpdateResult replaceOne(Bson filter, TDocument replacement) {
        return mongoCollection.replaceOne(filter, replacement);
    }

    @Override
    public UpdateResult replaceOne(Bson filter, TDocument replacement, UpdateOptions updateOptions) {
        return mongoCollection.replaceOne(filter, replacement, updateOptions);
    }

    @Override
    public UpdateResult updateOne(Bson filter, Bson update) {
        return mongoCollection.updateOne(filter, update);
    }

    @Override
    public UpdateResult updateOne(Bson filter, Bson update, UpdateOptions updateOptions) {
        return mongoCollection.updateOne(filter, update, updateOptions);
    }

    @Override
    public UpdateResult updateMany(Bson filter, Bson update) {
        return mongoCollection.updateMany(filter, update);
    }

    @Override
    public UpdateResult updateMany(Bson filter, Bson update, UpdateOptions updateOptions) {
        return mongoCollection.updateMany(filter, update, updateOptions);
    }

    @Override
    public TDocument findOneAndDelete(Bson filter) {
        return mongoCollection.findOneAndDelete(filter);
    }

    @Override
    public TDocument findOneAndDelete(Bson filter, FindOneAndDeleteOptions options) {
        return mongoCollection.findOneAndDelete(filter, options);
    }

    @Override
    public TDocument findOneAndReplace(Bson filter, TDocument replacement) {
        return mongoCollection.findOneAndReplace(filter, replacement);
    }

    @Override
    public TDocument findOneAndReplace(Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        return mongoCollection.findOneAndReplace(filter, replacement, options);
    }

    @Override
    public TDocument findOneAndUpdate(Bson filter, Bson update) {
        return mongoCollection.findOneAndUpdate(filter, update);
    }

    @Override
    public TDocument findOneAndUpdate(Bson filter, Bson update, FindOneAndUpdateOptions options) {
        return mongoCollection.findOneAndUpdate(filter, update, options);
    }

    @Override
    public void drop() {
        mongoCollection.drop();
    }

    @Override
    public String createIndex(Bson keys) {
        return mongoCollection.createIndex(keys);
    }

    @Override
    public String createIndex(Bson keys, IndexOptions indexOptions) {
        return mongoCollection.createIndex(keys, indexOptions);
    }

    @Override
    public List<String> createIndexes(List<IndexModel> indexes) {
        return mongoCollection.createIndexes(indexes);
    }

    @Override
    public ListIndexesIterable<Document> listIndexes() {
        return mongoCollection.listIndexes();
    }

    @Override
    public <TResult> ListIndexesIterable<TResult> listIndexes(Class<TResult> tResultClass) {
        return mongoCollection.listIndexes(tResultClass);
    }

    @Override
    public void dropIndex(String indexName) {
        mongoCollection.dropIndex(indexName);
    }

    @Override
    public void dropIndex(Bson keys) {
        mongoCollection.dropIndex(keys);
    }

    @Override
    public void dropIndexes() {
        mongoCollection.dropIndexes();
    }

    @Override
    public void renameCollection(MongoNamespace newCollectionNamespace) {
        mongoCollection.renameCollection(newCollectionNamespace);
    }

    @Override
    public void renameCollection(MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        mongoCollection.renameCollection(newCollectionNamespace, renameCollectionOptions);
    }
}
