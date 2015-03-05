package com.pcms.model.func.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.model.BizException;
import com.pcms.model.func.dao.FuncDao;
import com.pcms.model.func.service.FuncService;
import com.pcms.model.func.vo.FuncVO;

@Service
public class FuncServiceImpl implements FuncService {
	@Inject
	private FuncDao dao;
	@Override
	public List getAllFuncs() throws DataAccessException {
		// TODO 自动生成的方法存根
		return dao.getAllFuncs();
	}

	@Override
	public <T> List queryFuncs(T entity) throws DataAccessException {
		// TODO 自动生成的方法存根
		return dao.queryFuncs(entity);
	}

	@Override
	public FuncVO findByFuncName(String Funcname) throws DataAccessException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public <T> boolean addFunc(T entity) throws DataAccessException {
		// TODO 自动生成的方法存根
		if (entity == null) {
			throw new BizException(FuncVO.class.getName() + "实体为空");
		}
		return dao.addFunc(entity);
	}

	@Override
	public <T> boolean editFunc(T entity) throws DataAccessException {
		// TODO 自动生成的方法存根
		return dao.editFunc(entity);
	}

	@Override
	public <T> boolean removeFunc(T entity) throws DataAccessException {
		// TODO 自动生成的方法存根
		return dao.removeFunc(entity);
	}

	

}
