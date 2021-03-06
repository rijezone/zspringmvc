/**
 * 
 */
package com.pcms.common.base.model.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * @author zhuming
 *
 */
public interface BaseService {

	 public List getAllObjects() throws DataAccessException;
	 
	 public <T> List queryObjects(T entity) throws DataAccessException;
		
	 public <T> boolean addObject(T entity) throws DataAccessException;
	 
	 public <T> boolean editObject(T entity) throws DataAccessException;
	 
	 public <T> boolean removeObject(T entity) throws DataAccessException;
}
