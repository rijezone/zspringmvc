package com.pcms.model.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.model.role.dao.RoleDao;
import com.pcms.model.role.service.RoleService;
import com.pcms.model.role.vo.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	public Role findById(String id) throws DataAccessException {
		return roleDao.findById(id);
	}

	@Override
	public void add(Role role) throws DataAccessException {
		roleDao.add(role);
	}

	@Override
	public boolean delete(Role role) throws DataAccessException {
		return roleDao.delete(role);
	}

	@Override
	public List<Role> query(Role role) throws DataAccessException {
		return roleDao.query(role);
	}

	@Override
	public boolean update(Role role) throws DataAccessException {
		return roleDao.update(role);
	}
}