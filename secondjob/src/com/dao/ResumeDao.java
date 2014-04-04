package com.dao;

import java.util.Iterator;
import java.util.List;
 

import org.bson.types.ObjectId;

import com.entity.Entity;
import com.utils.App;
import com.utils.L;
import com.utils.U;
import com.entity.ResumeEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ResumeDao {  
	
	private DB db = App.getInstance().getDBContext();
	
 
	public Entity add(ResumeEntity entity) {
		try { 
			DBCollection collection = db.getCollection("resume");
			DBObject dbo = new BasicDBObject();
			
			dbo.put("name", entity.getName());
			dbo.put("personid", entity.getPersonid());
			
			collection.insert(dbo);
			
			return entity;
		} catch (Exception e) {
			L.exception(this, e.getMessage());
			return null;
		}
	}
	
    public void delete(String id)  {  
    	try {
	    	 
			
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
    }  
    
	public void delete(ResumeEntity entity) {
		try {
			 
		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
	}
    
    public List<ResumeEntity> list(){
    	return null;
	}
	
    //分页
    public List<ResumeEntity> list(int start, int end){
		 
        return null;  
	}
	
	 public List<ResumeEntity> list(ResumeEntity entity) throws Exception{
	 
        return null;  
	}
	
	public ResumeEntity get(String id){
		try {
			 	return null;
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
			return new ResumeEntity();
		}
	}
	public static void main(String[] args) {

		try {
			//test git 
			MongoClient mongo = new MongoClient();//不指定host和port,默认使用本地数据库，
			DB db = mongo.getDB("secondjob");//获取指定名称的数据库对象
			DBCollection resumes = db.getCollection("resume");//获取指定名称的集合对象
			
			Iterator<DBObject> resumeIter = resumes.find().iterator();
			while(resumeIter.hasNext()){
				System.out.println(resumeIter.next());
			}
			
	//		DBObject zhangsan = new BasicDBObject();

//			zhangsan.put("name","zhangsan2");
//			zhangsan.put("desc", "js developer");
//		    resumes.insert(zhangsan);
//			ObjectId qid = new ObjectId("533e45396133112e51cb8375");
//			BasicDBObject queryObject = new BasicDBObject();
//			queryObject.put("_id", qid);
//			//queryObject.putAll((BSONObject)queryObject);
//			DBObject one = resumes.findOne( queryObject );
//			System.out.println(one);
//			ObjectId id = (ObjectId)one.get("_id");
//			System.out.println(one.get("_id"));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
