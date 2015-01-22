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
	
	private Integer id;
	private String deptNo;
	private String deptName;
	private String pNo;
	private String parentName;
	private String deptDesc;
	
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
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getpNo() {
		return pNo;
	}
}
