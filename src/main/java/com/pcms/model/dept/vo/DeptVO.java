/**
 * 
 */
package com.pcms.model.dept.vo;

import java.io.Serializable;

import com.pcms.common.base.model.vo.BaseVO;

/**
 * @author zhuming
 *
 */
public class DeptVO extends BaseVO implements Serializable{
/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer deptId;
	private String deptCode;
	private String deptName;
	private String parentCode;
	private String parentDeptName;
	private String deptDesc;
	private String createTime;
	private String updateTime;
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentDeptName() {
		return parentDeptName;
	}
	public void setParentDeptName(String parentDeptName) {
		this.parentDeptName = parentDeptName;
	}
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
