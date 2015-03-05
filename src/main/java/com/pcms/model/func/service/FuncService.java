package com.pcms.model.func.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pcms.model.func.vo.FuncVO;

public interface FuncService {
	public List getAllFuncs() throws DataAccessException;

	public <T> List queryFuncs(T entity) throws DataAccessException;

	public FuncVO findByFuncName(String Funcname) throws DataAccessException;

	public <T> boolean addFunc(T entity) throws DataAccessException;

	public <T> boolean editFunc(T entity) throws DataAccessException;

	public <T> boolean removeFunc(T entity) throws DataAccessException;
}
