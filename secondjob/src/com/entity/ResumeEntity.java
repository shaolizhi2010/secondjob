package com.entity;

import java.io.Serializable;

public class ResumeEntity implements com.entity.Entity, Serializable {

	private String id;
	private String name;
	private String personid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

}