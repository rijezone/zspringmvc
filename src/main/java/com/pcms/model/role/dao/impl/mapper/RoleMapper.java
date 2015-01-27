package com.pcms.model.role.dao.impl.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pcms.model.SqlMapper;
import com.pcms.model.role.vo.Role;

/**
 * @author baotq
 * 
 */
public interface RoleMapper extends SqlMapper {

	/**
	 * 根据主键查找角色
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	Role findById(String id) throws DataAccessException;

	/**
	 * 查找角色
	 * 
	 * @param role
	 * @return
	 * @throws DataAccessException
	 */
	List<Role> query(Role role) throws DataAccessException;

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 * @throws DataAccessException
	 */
	void add(Role role) throws DataAccessException;

	/**
	 * 删除角色
	 * 
	 * @param role
	 * @throws DataAccessException
	 */
	boolean delete(Role role) throws DataAccessException;

	/**
	 * 修改角色
	 * 
	 * @param role
	 * @return
	 * @throws DataAccessException
	 */
	boolean update(Role role) throws DataAccessException;
}