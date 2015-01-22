/**
 * 
 */
package com.pcms.model.logs.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.model.logs.dao.UserLogDao;
import com.pcms.model.logs.service.UserLogService;
import com.pcms.model.logs.vo.UserLogVO;

/**
 * @Description: TODO
 * @author by mizh
 * @date 2015-1-22 下午3:22:41
 *
 */
@Service
public class UserLogServiceImpl implements UserLogService {
	@Inject
	private UserLogDao dao;
	
	/* (non-Javadoc)
	 * @see com.pcms.model.logs.service.UserLogService#getAllUserLogs()
	 */
	public List<UserLogVO> getAllUserLogs() throws DataAccessException {
		
		return dao.getAllUserLogs();
	}

	/* (non-Javadoc)
	 * @see com.pcms.model.logs.service.UserLogService#addUserLogs(java.lang.Object)
	 */
	public <T> boolean addUserLogs(T entity) throws DataAccessException {
		boolean flag = false;
		try {
			dao.addUserLogs(entity);
			flag = true;
		} catch (DataAccessException e) {
			throw e;
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.pcms.model.logs.service.UserLogService#removeUserLogs(java.lang.Object)
	 */
	public <T> boolean deleteUserLogs(T entity) throws DataAccessException {
		boolean flag = false;
		try {
			dao.deleteUserLogs(entity);
			flag = true;
		} catch (DataAccessException e) {
			throw e;
		}
		return flag;
	}

	
}
