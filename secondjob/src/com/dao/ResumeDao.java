package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
 








import com.codegen.dao.DaoGenerator;
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
 
	public Entity add(Entity entity) {
		try {
		 

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
			DB db = mongo.getDB("test");//获取指定名称的数据库对象
			DBCollection resumes = db.getCollection("resume");//获取指定名称的集合对象
			 
//			DBObject zhangsan = new BasicDBObject();
//			zhangsan.put("_id",1);
//			zhangsan.put("name","zhangsan");
//			zhangsan.put("desc", "php developer");
//		    resumes.insert(zhangsan);
			
			DBObject one = resumes.findOne(new BasicDBObject("name1","zhangsan"));
			System.out.println(one.toString());
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
