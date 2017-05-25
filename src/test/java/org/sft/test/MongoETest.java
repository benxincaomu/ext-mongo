package org.sft.test;


import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sft.os.mongo.MongoE;
import org.sft.os.mongo.collections.CollectionE;
import org.sft.os.mongo.databases.DatabaseE;
import org.sft.test.model.Master;
import org.sft.test.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class MongoETest {
    private MongoE mongoE;
    private DatabaseE databaseE;

    @Before
    public void before() {
        String host = "127.0.0.1";
        int port = 27017;
        mongoE = new MongoE(host, port);
        databaseE = mongoE.getDataBaseE("testE");

    }

    @After
    public void after() {
        mongoE.close();
    }

    @Test
    public void insert() {
        CollectionE<Master> masterCollectionE = databaseE.getCollectionE("Master", Master.class);
        Master master = new Master();
        master.setName("master0");
        master.setAddr("beijingshi");
        List<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        pet.setType("cat");
        pet.setAge(1);
        pet.setDescription("一年的猫");
        pets.add(pet);
        master.setPets(pets);
        masterCollectionE.insertOne(master);
    }

    @Test
    public void read() {
        CollectionE<Master> masterCollectionE = databaseE.getCollectionE("Master", Master.class);
        FindIterable<Master> masters = masterCollectionE.find();
        masters.forEach(new Block<Master>() {
            @Override
            public void apply(Master master) {
                System.out.println(JSONObject.toJSONString(master));
            }
        });
    }

}
