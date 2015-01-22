package com.pcms.model.dept.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.model.dept.dao.DeptDao;
import com.pcms.model.dept.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	@Inject
	private DeptDao dao;

	public List getAllObjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.getAllObjects();
	}

	public <T> List queryObjects(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.queryObjects(entity);
	}

	public <T> boolean addObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.addObject(entity);
	}

	public <T> boolean editObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.editObject(entity);
	}

	public <T> boolean removeObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.removeObject(entity);
	}

}
