package com.dao.baseDao;

import java.util.List;
 

import com.entity.Entity;
import com.utils.App;
import com.utils.L;

public class BaseDao {

	/*
	public Entity add(Entity entity) {
		try {
			
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(entity);
			tx.commit();
		
			session.close();

			return entity;
		} catch (Exception e) {
			L.exception(this, e.getMessage());
			return null;
		}
	}
	
    public void delete(String id) throws HibernateException {  
    	try {
	    	Session session = sessionFactory.openSession();
	    	Transaction tx = session.beginTransaction();  
	    	$entityName$Entity entity = ($entityName$Entity) session.load($entityName$Entity.class, id);  
	        session.delete(entity);  
	        tx.commit();
			
			session.close();
    	} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
    }  
    
	public void delete($entityName$Entity entity) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
	}
    
	
    public List<$entityName$Entity> getAll() throws HibernateException {  
        String queryString = "from $entityName$Entity";  
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(queryString);  
        List<$entityName$Entity> it = query.list();  
        return it;  
    } 
  
	public SearchHistoryEntity get(String shopname, String keyword) {
		L.log(this, "shopname = " + shopname + " keyword=" + keyword);
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from search_history where shopname=:shopname and keyword=:keyword");
		
		query.setString("shopname", shopname);
		query.setString("keyword", keyword);
		query.addEntity(SearchHistoryEntity.class);
		
		Object o = query.uniqueResult();
		
		session.close();
		
		if(o==null){
			return new SearchHistoryEntity();
		}
		return (SearchHistoryEntity)o;
	}
	
    
    public Iterator getSome(String name) throws HibernateException {  
        String queryString = " from User as u where u.name like :name";  
        Session session = sessionFactory.openSession();
        session.beginTransaction();  
        Query query = session.createQuery(queryString);  
        query.setString("name", "%" + name + "%");  
        Iterator it = query.iterate();  
        return it;  
    }   
	*/
}
