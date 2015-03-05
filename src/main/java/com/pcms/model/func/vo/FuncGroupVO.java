package com.pcms.model.func.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pcms.common.base.model.vo.BaseVO;

public class FuncGroupVO extends BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private BigDecimal groupId;

	private String funcBh;

	private String gdesc;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getGroupId() {
		return groupId;
	}

	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	public String getFuncBh() {
		return funcBh;
	}

	public void setFuncBh(String funcBh) {
		this.funcBh = funcBh == null ? null : funcBh.trim();
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc == null ? null : gdesc.trim();
	}
}