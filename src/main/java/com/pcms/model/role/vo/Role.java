package com.pcms.model.role.vo;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author baotq
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = -8890143292870239662L;

	private Long roleId; // 主键

	private String roleCode; // 角色编号

	private String roleName; // 角色名称

	private String roleType; // 角色类型

	private String roleDesc; // 角色描述

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}