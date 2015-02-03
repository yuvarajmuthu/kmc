package com.kmc.db;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBDAO {
	//private static MongoOperations mongoOperations = null;
	private MongoClient mongoClient = null;
	private DB mongoDB = null;
	private final String MONGO_SERVER_NAME = "localhost";
	private final int MONGO_SERVER_PORT = 27017;
//	public static MongoOperations getMongoOperations() {
//		if(mongoOperations == null) {1111
//			ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
//			mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
//		}
//		
//		return mongoOperations;}
	private MongoClient getMongoClient() {		
		if(mongoClient == null) {
			try {
				mongoClient = new MongoClient( MONGO_SERVER_NAME , MONGO_SERVER_PORT );
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mongoClient;
	}

	private DB getMongoDB(String dbName) {
		if(mongoDB == null)
			mongoDB = getMongoClient().getDB( dbName );
		
		return mongoDB;
	}
	
	//create all the mongodb crud methods here. Input/Ouput from/to mongodb adapter. Business tier talks directly talks to monogodb adapter
	//Get all the collection names for the db
	public Set<String> getCollectionNames(String dbName){
		return getMongoDB(dbName).getCollectionNames();
	}
	
	//Get the DBCollection object for the given collection name
	public DBCollection getCollection(String dbName, String collectionName){
		return getMongoDB(dbName).getCollection(collectionName);
	}
	
	private BasicDBObject buildDBObject (Map inputDataMap) {
		Set keys = inputDataMap.keySet();
		BasicDBObject parentDBObject = null;
		BasicDBObject childDBObject = null;
		
		Iterator keysIterator = keys.iterator();
		String key = null;
		Object value = null;
		while (keysIterator.hasNext()) {
			key = (String) keysIterator.next();
			value  = inputDataMap.get(key);
			
			parentDBObject = new BasicDBObject();
			
			
			if(value instanceof Map) {
				childDBObject = buildDBObject((Map)value);
				parentDBObject.append(key, childDBObject);
			} else {
				parentDBObject.append(key, value);
			} 
			
		}
		
		return parentDBObject;
	}
	
	public WriteResult insertDocument (String collectionName, Map inputDataMap) {
		BasicDBObject dbObject = buildDBObject(inputDataMap);
		return getCollection("kmc", collectionName).insert(dbObject);
	}
}
