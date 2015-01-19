/**
 * 
 */
package com.pcms.controller.dept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcms.common.base.controller.BaseControl;
import com.pcms.model.dept.service.DeptService;
import com.pcms.model.dept.vo.DeptVO;

/**
 * @description Department Management
 * @author zhuming
 * @version 2015 11:43:48 AM
 */
@Controller
@RequestMapping("/deptController")
public class DeptController extends BaseControl{


	@Inject
	private DeptService deptService;

	@RequestMapping("/initMain")
	public String initMain(Model model) {
		return "/views/dept/department.jsp";
	}

	@RequestMapping(value="/getDatasInJSON",method=RequestMethod.POST)  
	public @ResponseBody List<DeptVO> getDatasInJSON(HttpServletRequest request, HttpServletResponse response) {  
		String queryName = request.getParameter("queryName");
		String createTime = request.getParameter("createTime");
		System.out.println(queryName);
		Map<String,String> map = new HashMap<String,String>();
		map.put("queryName",queryName==null?null:"%"+queryName+"%");
		map.put("createTime", createTime);
		List<DeptVO> list = deptService.queryObjects(map);  
		return list;  
	}
}
