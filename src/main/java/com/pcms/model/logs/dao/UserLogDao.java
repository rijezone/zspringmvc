/**
 * 
 */
package com.pcms.model.logs.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.pcms.model.logs.vo.UserLogVO;

/**
 * @Description: TODO
 * @author by mizh
 * @date 2015-1-22 下午3:28:54
 *
 */
public interface UserLogDao {
	
	public List<UserLogVO> getAllUserLogs() throws DataAccessException;

	public <T> boolean addUserLogs(T entity) throws DataAccessException;

	public <T> boolean deleteUserLogs(T entity) throws DataAccessException;
	
}
