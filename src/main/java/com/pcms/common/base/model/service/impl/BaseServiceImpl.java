package com.pcms.common.base.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;

import com.pcms.common.base.model.dao.BaseDao;
import com.pcms.common.base.model.service.BaseService;

public class BaseServiceImpl implements BaseService{
	@Inject
	private BaseDao dao;

	public List getAllObjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.getAllObjects();
	}
	public <T> List queryObjects(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.queryObjects(entity);
	}
	public <T> boolean addObject(T entity) throws DataAccessException {
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
