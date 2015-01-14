/**
 * 
 */
package com.pcms.model.user.mapper;

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
	 
	@Select("select * from t_user where userName = #{userName}")
    public UserVO getUserByName(String userName);
    
    public void addUser(UserVO userVO);

    public void editUser(UserVO userVO);

    public void removeUser(UserVO userVO);

}
