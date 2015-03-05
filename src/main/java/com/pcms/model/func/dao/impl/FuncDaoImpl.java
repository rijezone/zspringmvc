package com.pcms.model.func.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pcms.model.func.dao.FuncDao;
import com.pcms.model.func.dao.mapper.FuncMapper;
import com.pcms.model.func.vo.FuncVO;

@Repository
public class FuncDaoImpl implements FuncDao {
	@Inject
	private FuncMapper mapper;

	public List<?> getAllFuncs() throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<?>) mapper.getAllFuncs();
	}

	@SuppressWarnings("unchecked")
	public <T> List<?> queryFuncs(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<?>) mapper.queryFuncByProperty((Map<String, Object>) entity);
	}

	public <T> boolean addFunc(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			mapper.addFunc((FuncVO) entity);
			flag = true;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public <T> boolean editFunc(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			mapper.editFunc((FuncVO) entity);
			flag = true;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public <T> boolean removeFunc(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			mapper.removeFunc((FuncVO) entity);
			flag = true;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

}
