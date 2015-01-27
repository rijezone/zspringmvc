package com.pcms.model.role.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pcms.model.role.vo.Role;

/**
 * @author baotq
 * 
 */
public interface RoleService {

	Role findById(String id) throws DataAccessException;

	List<Role> query(Role role) throws DataAccessException;

	void add(Role role) throws DataAccessException;

	boolean delete(Role role) throws DataAccessException;

	boolean update(Role role) throws DataAccessException;
}