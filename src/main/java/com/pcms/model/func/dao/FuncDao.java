package com.pcms.model.func.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface FuncDao{
	public List getAllFuncs() throws DataAccessException;

	public <T> List queryFuncs(T entity) throws DataAccessException;

	public <T> boolean addFunc(T entity) throws DataAccessException;

	public <T> boolean editFunc(T entity) throws DataAccessException;

	public <T> boolean removeFunc(T entity) throws DataAccessException;
}
