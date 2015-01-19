/**
 * 
 */
package com.pcms.model.dept.vo;

import java.io.Serializable;

/**
 * @author zhuming
 *
 */
public class DeptVO implements Serializable{
/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
	/*
 *   id      INTEGER not null,
  dept_no VARCHAR2(10 CHAR),
  dname   VARCHAR2(30 CHAR),
  p_no    INTEGER,
  ddesc   VARCHAR2(60 CHAR),
  col1    VARCHAR2(100 CHAR),
  col2    VARCHAR2(100 CHAR),
  col3    VARCHAR2(100 CHAR)
 */
	private Integer id;
	private String deptNo;
	private String deptName;
	private Integer pNo;
	private String deptDesc;
	private String createTime;
	private String updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
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
