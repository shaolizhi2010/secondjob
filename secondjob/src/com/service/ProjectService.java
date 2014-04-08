package com.service;

import java.util.List;

import com.dao.ProjectDao;
import com.entity.Entity;
import com.entity.ProjectEntity;

public class ProjectService {
	ProjectDao projectDao = new ProjectDao();

	public void add(ProjectEntity entity) {
		projectDao.add(entity);
	}

	public void delete(String id)  {
		projectDao.delete(id);
	}

	public void delete(ProjectEntity entity) {
		projectDao.delete(entity);
	}

	public List<ProjectEntity> list() {
		return projectDao.list();
	}

	public List<ProjectEntity> list(int start, int end) {
		return projectDao.list(start, end);
	}

	public List<ProjectEntity> list(ProjectEntity entity) throws Exception {
		return projectDao.list(entity);
	}

	public ProjectEntity get(String id) {
		return projectDao.get(id);
	}
 
	
	
}
