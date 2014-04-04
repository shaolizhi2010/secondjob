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
 	private String person_information_id;
	
	public String getPerson_information_id() {
		return person_information_id;
	}
	
	public void setPerson_information_id(String person_information_id) {
		this.person_information_id = person_information_id;
	}
 

	public String create() {
		
		ResumeEntity entity = new ResumeEntity();

		entity.setId(id);
entity.setName(name);
entity.setPerson_information_id(person_information_id);

		 
		ResumeService service = new ResumeService();
		service.add(entity);
		
		return "list";
	}
	
	public String list() {
		ResumeEntity entity = new ResumeEntity();

		entity.setId(id);
entity.setName(name);
entity.setPerson_information_id(person_information_id);


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