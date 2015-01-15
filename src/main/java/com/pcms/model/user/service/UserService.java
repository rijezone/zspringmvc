/**
 * 
 */
package com.pcms.model.user.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pcms.model.user.vo.UserVO;

/**
 * @author zhuming
 *
 */
public interface UserService {

	 public List getAllUsers() throws DataAccessException;
	 
	 public <T> List queryUsers(T entity) throws DataAccessException;
	 
	 public UserVO findByUsername(String username) throws DataAccessException;
		
	 public <T> boolean addUser(T entity) throws DataAccessException;
	 
	 public <T> boolean editUser(T entity) throws DataAccessException;
	 
	 public <T> boolean removeUser(T entity) throws DataAccessException;
}
