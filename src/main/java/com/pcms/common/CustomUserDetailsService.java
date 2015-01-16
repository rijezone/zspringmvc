package com.pcms.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pcms.model.user.dao.impl.UserDaoImpl;
import com.pcms.model.user.vo.UserVO;

/**
 * 一个自定义的类用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * 
 * @author 
 * 
 */
public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger.getLogger("service");//log4j，不用解释了吧。。

	public UserDaoImpl userService = new UserDaoImpl(); 
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails user = null;
		try {
			String sql = "select userid,username,userpass,userdept,userrole,email,phone,to_char(createtime,'yyyy-mm-dd hh24:mi:ss')createtime,to_char(updatetime,'yyyy-mm-dd hh24:mi:ss')updatetime from t_user where u.userName=?";
		    Object[] args = new Object[] { username };  
	        UserVO u = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper(UserVO.class));
	        System.out.println(u);
			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct
			// role type
			// 用户名、密码、是否启用、是否被锁定、是否过期、权限
			user = new User(u.getUserName(), u.getUserPass().toLowerCase(), true, true, true, true, getAuthorities(Integer.parseInt(u.getUserRole())));
		} catch (Exception e) {
			logger.error("用户信息错误！");
			throw new UsernameNotFoundException("异常处理：检索用户信息未通过！");
		}
		return user;
	}

	/**
	 * 获得访问角色权限列表
	 * 
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer role) {
		System.out.println("取得的权限是  :" + role);
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		// 所有的用户默认拥有ROLE_USER权限
		if (role == 0) {
			System.out.println("普通用户");
			logger.debug("取得普通用户权限-->");
			authList.add(new GrantedAuthorityImpl("ROLE_USERS"));
		}
		// 如果参数role为1.则拥有ROLE_ADMIN权限
		if (role == 1) {
			logger.debug("取得ADMIN用户权限-->");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		System.out.println(authList.size()+"  权限列表长度");
		return authList;
	}
}
