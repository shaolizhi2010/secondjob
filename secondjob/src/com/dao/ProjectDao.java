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

import com.entity.ProjectEntity;

public class ProjectDao {
	
	private DB db = App.getInstance().getDBContext();
	private DBCollection collection = db.getCollection("project");
	
	public void add(ProjectEntity entity) {
		try {
			
			DBCollection collection = db.getCollection("project");
			DBObject dbo = new BasicDBObject();
			
if(U.toString(entity.getId()).length()>0){dbo.put("_id", new ObjectId(entity.getId()));}
			
			if(U.toString(entity.getName()).length()>0){
				dbo.put("name", entity.getName());
			}			
			if(U.toString(entity.getDescription()).length()>0){
				dbo.put("description", entity.getDescription());
			}
			
			collection.insert(dbo);

		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
	}
	
    public void delete(String id) {  
    	try {
			DBObject o = new BasicDBObject();
			o.put("_id", new ObjectId(id));
			
			collection.remove(o);
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
    }  
    
	public void delete(ProjectEntity entity) {
		try {
			String id = entity.getId();
			delete(id);
		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
	}
    
    public List<ProjectEntity> list(){
		return list(new ProjectEntity());
	}
	
    //分页
    public List<ProjectEntity> list(int start, int end){
		
    	if(start == 0){
    		return list();
    	}
    	return list();
	}
	
	 public List<ProjectEntity> list(ProjectEntity entity) {
			
			List<ProjectEntity> entityList = new ArrayList<ProjectEntity>();
			DBObject dbo = new BasicDBObject();
if(U.toString(entity.getId()).length()>0){dbo.put("_id", new ObjectId(entity.getId()));}
			
			if(U.toString(entity.getName()).length()>0){
				dbo.put("name", entity.getName());
			}			
			if(U.toString(entity.getDescription()).length()>0){
				dbo.put("description", entity.getDescription());
			}
	
			Iterator<DBObject> list = collection.find(dbo).iterator();
			
			
			
			while(list.hasNext()){
				
				ProjectEntity e = new ProjectEntity();
				DBObject dbo1 = list.next();
				
e.setId(dbo1.get("_id").toString());
				e.setName(  U.toString( dbo1.get("name") ) );
				e.setDescription(  U.toString( dbo1.get("description") ) );

				entityList.add(e);
			}
			return entityList;
		 
	}
	
	public ProjectEntity get(String id){
		try {
		 	ProjectEntity e = new ProjectEntity();
			DBObject o = new BasicDBObject();
			o.put("_id", new ObjectId(id));
			
			DBObject dbo1 = collection.findOne(o);
			
			e.setId(dbo1.get("_id").toString());
				e.setName(  U.toString( dbo1.get("name") ) );
				e.setDescription(  U.toString( dbo1.get("description") ) );

			
			return e;
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
			return new ProjectEntity();
		}
	}
	
	public void update(ProjectEntity entity){
		
		DBObject o = new BasicDBObject();
		
		//DBObject dbo = collection.update(q, o)
		
		//entity.setName(U.toString( dbo.get("name") ));
		
	}
 
}
