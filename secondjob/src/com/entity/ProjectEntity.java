package com.entity;

import java.io.Serializable;
 
public class ProjectEntity implements com.entity.Entity, Serializable {
	
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
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	private String payperhour;
	
	public String getPayperhour() {
		return payperhour;
	}
	
	public void setPayperhour(String payperhour) {
		this.payperhour = payperhour;
	}
	
	private String project_request;
	
	public String getProject_request() {
		return project_request;
	}
	
	public void setProject_request(String project_request) {
		this.project_request = project_request;
	}
	
	
	
}