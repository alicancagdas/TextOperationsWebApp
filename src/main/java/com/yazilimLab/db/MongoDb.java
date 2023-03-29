package com.yazilimLab.db;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.Collection;

public class MongoDb implements IDataBase{
    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;

    @Override
    public void add(ArrayList<String> list) {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("YazilimLab1");
        test = database.getCollection("ProjectCollection");
        test.insert(convert(list));
    }

    public static DBObject convert(ArrayList<String> list) {
        int a = 0;
        BasicDBObject converted = new BasicDBObject();

            for (String str: list) {
                a++;
                converted.append("Sentence" + a, str).toJson();
            }

        return converted;
    }



}