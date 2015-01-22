/**
 * @location com.pcms.common.base.model.voBaseVO.java
 * @time 2015 11:27:38 AM 
 */
package com.pcms.common.base.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @description 基类  值对象
 * @author zhuming
 * @version 2015 11:27:38 AM
 */
public class BaseVO implements Serializable{
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
	
	private String createTime;
	private String updateTime;
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
