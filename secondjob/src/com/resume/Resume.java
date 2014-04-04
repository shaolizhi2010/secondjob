package com.resume;

import java.util.List;

import org.springframework.context.annotation.Lazy;

public class Resume implements com.entity.Entity {

	private String id;

	private String name;

	private PersonalInformation personalInformation;

	//

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

	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	// private ContactInformation contactInformation;

	// private List<Experience> experienceList;

}
