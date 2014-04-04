package com.web;

import com.web.base.BaseAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.utils.L;

import com.service.ResumeService;
import com.entity.ResumeEntity;

public class ResumeAction extends BaseAction {

		private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
 	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 	private String personid;
	
	public String personid() {
		return personid;
	}
	
	public void setPersonid(String personid) {
		this.personid = personid;
	}
 

	public String create() {
		
		ResumeEntity entity = new ResumeEntity();
		entity.setName(name);
		entity.setPersonid(personid);
		 
		ResumeService service = new ResumeService();
		service.add(entity);
		
		return "list";
	}
	
	public String list() {
		ResumeEntity entity = new ResumeEntity();

		ResumeService service = new ResumeService();
		try {
			List<ResumeEntity> list = service.list(entity);
			HttpServletRequest request = ServletActionContext.getRequest ();
			request.setAttribute("list", list);
		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
		return "listPage";
	}
	
	public String view(){

		ResumeService service = new ResumeService();
		ResumeEntity entity = service.get(id+"");
		HttpServletRequest request = ServletActionContext.getRequest ();
		request.setAttribute("entity", entity);
	
		return "view";
	}
 	
 	public String delete(){
		ResumeService service = new ResumeService();
		try{
			service.delete(id+"");
		}catch(Exception e){
			L.exception(this, e.getMessage());
		}
		
		return "list";
	}

}