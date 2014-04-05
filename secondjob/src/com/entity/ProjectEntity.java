package com.entity;

import java.io.Serializable;

import com.codegen.common.annotation.MaxLength;
 
public class ProjectEntity implements com.entity.Entity, Serializable {
	
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
	
	@MaxLength(value="10000")
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
 
	
	
	
}