package com.pcms.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.role.mapper.RoleMapper;
import com.pcms.role.model.Role;
import com.pcms.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public Role findById(String id) throws DataAccessException {
		return roleMapper.findById(id);
	}

	@Override
	public void add(Role role) throws DataAccessException {
		roleMapper.add(role);
	}

	@Override
	public boolean delete(Role role) throws DataAccessException {
		return roleMapper.delete(role);
	}

	@Override
	public List<Role> query(Role role) throws DataAccessException {
		return roleMapper.query(role);
	}

	@Override
	public boolean update(Role role) throws DataAccessException {
		return roleMapper.update(role);
	}
}