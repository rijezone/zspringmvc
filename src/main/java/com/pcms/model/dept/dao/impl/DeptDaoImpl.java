package com.pcms.model.dept.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pcms.model.dept.dao.DeptDao;
import com.pcms.model.dept.dao.mapper.DeptMapper;
import com.pcms.model.dept.vo.DeptVO;


@Repository
public class DeptDaoImpl implements DeptDao{
	@Inject
    private DeptMapper mapper;

	public List getAllObjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return mapper.getAllDepts();
	}

	public <T> List queryObjects(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<?>) mapper.queryDeptByProperty((Map<String, Object>) entity);
	}

	public <T> boolean addObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.addDept((DeptVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}

	public <T> boolean editObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.editDept((DeptVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}

	public <T> boolean removeObject(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		boolean flag = false;
        try {
            mapper.removeDept((DeptVO) entity);
            flag = true;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
	}
}
