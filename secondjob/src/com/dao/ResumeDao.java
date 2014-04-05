package com.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import com.utils.App;
import com.utils.L;
import com.utils.U;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import com.entity.ResumeEntity;

public class ResumeDao {
	
	private DB db = App.getInstance().getDBContext();
	private DBCollection collection = db.getCollection("resume");
	
	public void add(ResumeEntity entity) {
		try {
			
			DBCollection collection = db.getCollection("resume");
			DBObject dbo = new BasicDBObject();
			
if(U.toString(entity.getId()).length()>0){dbo.put("_id", new ObjectId(entity.getId()));}
			
			if(U.toString(entity.getName()).length()>0){
				dbo.put("name", entity.getName());
			}			
			if(U.toString(entity.getPersonid()).length()>0){
				dbo.put("personid", entity.getPersonid());
			}
			
			collection.insert(dbo);

		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
	}
	
    public void delete(String id) {  
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
		
    	if(start == 0){
    		return list();
    	}
    	 return null;
	}
	
	 public List<ResumeEntity> list(ResumeEntity entity) throws Exception{
			
			List<ResumeEntity> entityList = new ArrayList<ResumeEntity>();
			DBObject dbo = new BasicDBObject();
if(U.toString(entity.getId()).length()>0){dbo.put("_id", new ObjectId(entity.getId()));}
			
			if(U.toString(entity.getName()).length()>0){
				dbo.put("name", entity.getName());
			}			
			if(U.toString(entity.getPersonid()).length()>0){
				dbo.put("personid", entity.getPersonid());
			}
	
			Iterator<DBObject> list = collection.find(dbo).iterator();
			
			
			
			while(list.hasNext()){
				
				ResumeEntity e = new ResumeEntity();
				DBObject dbo1 = list.next();
				
e.setId(dbo1.get("_id").toString());
				e.setName(  U.toString( dbo1.get("name") ) );
				e.setPersonid(  U.toString( dbo1.get("personid") ) );

				entityList.add(e);
			}
			return entityList;
		 
	}
	
	public ResumeEntity get(String id){
		try {
		 	return null;
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
			return new ResumeEntity();
		}
	}
 
}
