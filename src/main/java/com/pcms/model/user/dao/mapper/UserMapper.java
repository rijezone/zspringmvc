/**
 * 
 */
package com.pcms.model.user.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.pcms.model.SqlMapper;
import com.pcms.model.user.vo.UserVO;

/**
 * @author zhuming
 *
 */
public interface UserMapper extends SqlMapper{
	
	public List getAllUsers();
	
	public List queryUsers(Map<String,Object> entity);
	 
    public UserVO findByUsername(String userName);
    
    public void addUser(UserVO userVO);

    public void editUser(UserVO userVO);

    public void removeUser(UserVO userVO);

}
