package com.service;

import java.util.List;

import com.dao.ResumeDao;
import com.entity.Entity;
import com.entity.ResumeEntity;

public class ResumeService {
	ResumeDao resumeDao = new ResumeDao();

	public void add(ResumeEntity entity) {
		resumeDao.add(entity);
	}

	public void delete(String id)  {
		resumeDao.delete(id);
	}

	public void delete(ResumeEntity entity) {
		resumeDao.delete(entity);
	}

	public List<ResumeEntity> list() {
		return resumeDao.list();
	}

	public List<ResumeEntity> list(int start, int end) {
		return resumeDao.list(start, end);
	}

	public List<ResumeEntity> list(ResumeEntity entity) throws Exception {
		return resumeDao.list(entity);
	}

	public ResumeEntity get(String id) {
		return resumeDao.get(id);
	}
 
	
	
}
