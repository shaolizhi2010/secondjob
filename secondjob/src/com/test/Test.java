package com.test;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.utils.U;

public class Test {

	public static void main(String[] args) {
		try {
//			MongoClient mongo = new MongoClient();// 不指定host和port,默认使用本地数据库，
//			DB db = mongo.getDB("secondjob");// 获取指定名称的数据库对象
//			DBCollection resumes = db.getCollection("resume");// 获取指定名称的集合对象
//
//		 
//			Iterator<DBObject> list = resumes.find().iterator();
//			while(list.hasNext()){
//				System.out.println(list.next());
//			}http://localhost:8080/secondjob/project!delete.action?id=533fc61de4b051a9158240bd

			MongoClient mongo = new MongoClient();// 不指定host和port,默认使用本地数据库，
			DB db = mongo.getDB("secondjob");// 获取指定名称的数据库对象
			DBCollection collection = db.getCollection("project");// 获取指定名称的集合对象
			
			DBObject o = new BasicDBObject();
			o.put("_id", new ObjectId("533fc61de4b051a9158240bd"));
			
			//collection.remove(o);
			
			DBObject dbo = collection.findOne(o);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
