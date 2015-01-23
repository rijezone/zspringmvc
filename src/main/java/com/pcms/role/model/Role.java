package com.pcms.role.model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author baotq
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = -8890143292870239662L;

	private Long id; // 主键

	private String code; // 角色编号

	private String name; // 角色名称

	private String type; // 角色类型

	private String desc; // 角色描述

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}