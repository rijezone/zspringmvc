package com.pcms.model.role.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pcms.model.role.dao.RoleDao;
import com.pcms.model.role.dao.impl.mapper.RoleMapper;
import com.pcms.model.role.vo.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Inject
	private RoleMapper roleMapper;

	@Override
	public Role findById(String id) throws DataAccessException {
		return roleMapper.findById(id);
	}

	@Override
	public List<Role> query(Role role) throws DataAccessException {
		return roleMapper.query(role);
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
	public boolean update(Role role) throws DataAccessException {
		return roleMapper.update(role);
	}
}