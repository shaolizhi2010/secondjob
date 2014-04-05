package com.entity;

import java.util.List;

public class PersonEntity {

	private String id;
	private String name;
	private String sex;
	private String age;

	private List<ResumeEntity> resumes;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<ResumeEntity> getResumes() {
		return resumes;
	}

	public void setResumes(List<ResumeEntity> resumes) {
		this.resumes = resumes;
	}

}
