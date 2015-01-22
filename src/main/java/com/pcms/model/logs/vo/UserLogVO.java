/**
 * 
 */
package com.pcms.model.logs.vo;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @Description: 用户登录日志
 * @author by mizh
 * @date 2015-1-20 下午6:04:32
 *
 */
@Entity
public class UserLogVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8698787354607515457L;

	private Integer Id;
	
	private String userBH;
	
	private String logHost;
	
	private String userName;
	
	private String logOn;
	
	private String logOut;
	
	private Integer logLvl;
	
	private String logEnt;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserBH() {
		return userBH;
	}

	public void setUserBH(String userBH) {
		this.userBH = userBH;
	}

	public String getLogHost() {
		return logHost;
	}

	public void setLogHost(String logHost) {
		this.logHost = logHost;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogOn() {
		return logOn;
	}

	public void setLogOn(String logOn) {
		this.logOn = logOn;
	}

	public String getLogOut() {
		return logOut;
	}

	public void setLogOut(String logOut) {
		this.logOut = logOut;
	}

	public Integer getLogLvl() {
		return logLvl;
	}

	public void setLogLvl(Integer logLvl) {
		this.logLvl = logLvl;
	}

	public String getLogEnt() {
		return logEnt;
	}

	public void setLogEnt(String logEnt) {
		this.logEnt = logEnt;
	}

	
}
