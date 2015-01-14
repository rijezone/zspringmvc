/**
 * 
 */
package com.pcms.model.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * @author zhuming
 *
 */
public interface UserDao {
	
	 public List getAllUsers() throws DataAccessException;
	 
	 public <T> List queryUsers(T entity) throws DataAccessException;
	
	 public <T> boolean addUser(T entity) throws DataAccessException;
	 
	 public <T> boolean editUser(T entity) throws DataAccessException;
	 
	 public <T> boolean removeUser(T entity) throws DataAccessException;
}
