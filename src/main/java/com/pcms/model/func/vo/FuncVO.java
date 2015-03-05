package com.pcms.model.func.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pcms.common.base.model.vo.BaseVO;

public class FuncVO extends BaseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String funcBh;

	private String funcName;

	private String parentBh;

	private String fdesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncBh() {
		return funcBh;
	}

	public void setFuncBh(String funcBh) {
		this.funcBh = funcBh == null ? null : funcBh.trim();
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName == null ? null : funcName.trim();
	}

	public String getParentBh() {
		return parentBh;
	}

	public void setParentBh(String parentBh) {
		this.parentBh = parentBh == null ? null : parentBh.trim();
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc == null ? null : fdesc.trim();
	}
}