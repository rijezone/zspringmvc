/**
 * 
 */
package com.pcms.model.logs.dao.mapper;

import java.util.List;

import com.pcms.model.SqlMapper;
import com.pcms.model.logs.vo.UserLogVO;

/**
 * @author zhuming
 *
 */
public interface UserLogMapper extends SqlMapper{
	
	public List<UserLogVO> getAllUserLogs();
	
    public void addUserLogs(UserLogVO userVO);

    public void deleteUserLogs(UserLogVO userVO);

}
