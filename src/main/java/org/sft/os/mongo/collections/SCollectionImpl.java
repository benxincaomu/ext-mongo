package org.sft.os.mongo.collections;

import com.mongodb.*;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.sft.os.mongo.codecs.MongoCodec;

import java.util.List;

/**
 * @author sunft
 */
public class SCollectionImpl<TDocument> implements SCollection<TDocument> {
    private MongoCollection<TDocument> mongoCollection;

    public SCollectionImpl(MongoCollection<TDocument> mongoCollection, Class<TDocument> tDocumentClass) {
        this.mongoCollection = mongoCollection;
        mongoCollection.withCodecRegistry(CodecRegistries.fromCodecs(new MongoCodec<TDocument>(tDocumentClass)));
    }

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

    public Class<TDocument> getDocumentClass() {
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

    public <NewTDocument> MongoCollection<NewTDocument> withDocumentClass(Class<NewTDocument> clazz) {
        return mongoCollection.withDocumentClass(clazz);
    }

    public MongoCollection<TDocument> withCodecRegistry(CodecRegistry codecRegistry) {
        return mongoCollection.withCodecRegistry(codecRegistry);
    }

    public MongoCollection<TDocument> withReadPreference(ReadPreference readPreference) {
        return mongoCollection.withReadPreference(readPreference);
    }

    public MongoCollection<TDocument> withWriteConcern(WriteConcern writeConcern) {
        return mongoCollection.withWriteConcern(writeConcern);
    }

    public MongoCollection<TDocument> withReadConcern(ReadConcern readConcern) {
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

    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Class<TResult> tResultClass) {
        return mongoCollection.distinct(fieldName, tResultClass);
    }

    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Bson filter, Class<TResult> aClass) {
        return mongoCollection.distinct(fieldName, filter, aClass);
    }

    public FindIterable<TDocument> find() {
        return mongoCollection.find();
    }

    public <TResult> FindIterable<TResult> find(Class<TResult> aClass) {
        return mongoCollection.find(aClass);
    }

    public FindIterable<TDocument> find(Bson filter) {
        return mongoCollection.find(filter);
    }

    public <TResult> FindIterable<TResult> find(Bson filter, Class<TResult> tResultClass) {
        return mongoCollection.find(filter, tResultClass);
    }

    public AggregateIterable<TDocument> aggregate(List<? extends Bson> pipeline) {
        return mongoCollection.aggregate(pipeline);
    }

    public <TResult> AggregateIterable<TResult> aggregate(List<? extends Bson> pipeline, Class<TResult> tResultClass) {
        return mongoCollection.aggregate(pipeline, tResultClass);
    }

    public MapReduceIterable<TDocument> mapReduce(String mapFunction, String reduceFunction) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction);
    }

    public <TResult> MapReduceIterable<TResult> mapReduce(String mapFunction, String reduceFunction, Class<TResult> tResultClass) {
        return mongoCollection.mapReduce(mapFunction, reduceFunction, tResultClass);
    }

    public BulkWriteResult bulkWrite(List<? extends WriteModel<? extends TDocument>> requests) {
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
