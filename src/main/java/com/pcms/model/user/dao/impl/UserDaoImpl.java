package com.pcms.model.user.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pcms.model.user.dao.UserDao;
import com.pcms.model.user.dao.mapper.UserMapper;
import com.pcms.model.user.vo.UserVO;


@Repository
public class UserDaoImpl implements UserDao{
	@Inject
    private UserMapper mapper;

	public List<?> getAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<?>) mapper.getAllUsers();
	}

	@SuppressWarnings("unchecked")
	public <T> List<?> queryUsers(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<?>) mapper.queryUsers((Map<String, Object>) entity);
	}

	public UserVO findByUsername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return mapper.findByUsername(username);
	}
	public <T> boolean addUser(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.addUser((UserVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}

	public <T> boolean editUser(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.editUser((UserVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}

	public <T> boolean removeUser(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.removeUser((UserVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}

}
