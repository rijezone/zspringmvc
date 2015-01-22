/**
 * 
 */
package com.pcms.model.logs.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pcms.model.logs.dao.UserLogDao;
import com.pcms.model.logs.mapper.UserLogMapper;
import com.pcms.model.logs.vo.UserLogVO;
import com.pcms.model.user.vo.UserVO;

/**
 * @Description: TODO
 * @author by mizh
 * @date 2015-1-22 下午3:30:20
 *
 */

@Repository
public class UserLogDaoImpl implements UserLogDao {
	@Inject
	private UserLogMapper mapper;
	
	/* (non-Javadoc)
	 * 获取所有登录日志
	 * @see com.pcms.model.logs.dao.UserLogDao#getAllUserLogs()
	 */
	public List<UserLogVO> getAllUserLogs() throws DataAccessException {
		return (List<UserLogVO>) mapper.getAllUserLogs();
	}

	/* (non-Javadoc)
	 * 记录登录日志
	 * @see com.pcms.model.logs.dao.UserLogDao#addUserLogs(java.lang.Object)
	 */
	public <T> boolean addUserLogs(T entity) throws DataAccessException {
		boolean flag = false;
		try {
			mapper.addUserLogs((UserLogVO) entity);
			flag = true;
		} catch (DataAccessException e) {
			throw e;
		}
		return flag;
	}

	/* (non-Javadoc)
	 * 删除登录日志
	 * @see com.pcms.model.logs.dao.UserLogDao#removeUserLogs(java.lang.Object)
	 */
	public <T> boolean deleteUserLogs(T entity) throws DataAccessException {
		boolean flag = false;
		
		try {
			mapper.deleteUserLogs((UserLogVO) entity);
			flag = true;
		} catch (DataAccessException e) {
			throw e;
		}
		return flag;
	}

}
