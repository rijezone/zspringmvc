package com.pcms.model.user.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.model.BizException;
import com.pcms.model.user.dao.UserDao;
import com.pcms.model.user.service.UserService;
import com.pcms.model.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	private UserDao dao;

	public List getAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}
	public <T> List queryUsers(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.queryUsers(entity);
	}
	public UserVO findByUsername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
	public <T> boolean addUser(T entity) throws DataAccessException {
		if (entity == null) {
			throw new BizException(UserVO.class.getName() + "���������ϢΪEmpty��");
		}
		return dao.addUser(entity);
	}
	public <T> boolean editUser(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.editUser(entity);
	}
	public <T> boolean removeUser(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return dao.removeUser(entity);
	}

}
