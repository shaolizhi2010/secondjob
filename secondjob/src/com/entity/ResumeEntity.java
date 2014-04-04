package com.entity;

import java.io.Serializable;


public class ResumeEntity implements com.entity.Entity, Serializable {
	
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
	
	
	
}