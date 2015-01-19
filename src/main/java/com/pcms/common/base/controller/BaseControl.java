/**
 * @location com.pcms.commonBaseControl.java
 * @time 2015 3:19:46 PM 
 */
package com.pcms.common.base.controller;

/**
 * @description 控制类基类
 * @author zhuming
 * @version 2015 3:19:46 PM
 */
public class BaseControl {
	protected String page;
	protected String rows;
	protected String sort;
	protected String order;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
