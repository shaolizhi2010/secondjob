package com.web;

import com.web.base.BaseAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.utils.L;

import com.service.ProjectService;
import com.entity.ProjectEntity;

public class ProjectAction extends BaseAction {

		private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
 	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
 

	public String create() {
		
		ProjectEntity entity = new ProjectEntity();

		entity.setId(id);
entity.setName(name);
entity.setDescription(description);

		 
		ProjectService service = new ProjectService();
		service.add(entity);
		
		return "list";
	}
	
	public String list() {
		ProjectEntity entity = new ProjectEntity();

		entity.setId(id);
entity.setName(name);
entity.setDescription(description);


		ProjectService service = new ProjectService();
		try {
			List<ProjectEntity> list = service.list(entity);
			HttpServletRequest request = ServletActionContext.getRequest ();
			request.setAttribute("list", list);
		} catch (Exception e) {
			L.exception(this, e.getMessage());
		}
		return "listPage";
	}
	
	public String view(){

		ProjectService service = new ProjectService();
		ProjectEntity entity = service.get(id);
		HttpServletRequest request = ServletActionContext.getRequest ();
		request.setAttribute("entity", entity);
	
		return "view";
	}
 	
 	public String delete(){
		ProjectService service = new ProjectService();
		try{
			service.delete(id+"");
		}catch(Exception e){
			L.exception(this, e.getMessage());
		}
		
		return "list";
	}

}