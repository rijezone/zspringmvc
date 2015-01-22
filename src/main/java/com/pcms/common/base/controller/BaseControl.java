/**
 * @location com.pcms.commonBaseControl.java
 * @time 2015 3:19:46 PM 
 */
package com.pcms.common.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description 控制类基类
 * @author zhuming
 * @version 2015 3:19:46 PM
 */
public abstract class BaseControl {
	protected String page;
	protected String rows;
	protected String sort;
	protected String order;
	
	public abstract String initMain(Model model);
	
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, HttpServletRequest request) {
        //e.printStackTrace();
        request.setAttribute("exception", e);
        return "/error.jsp";
    }
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
