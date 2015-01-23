package com.pcms.role.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcms.common.base.controller.BaseControl;
import com.pcms.model.user.vo.UserVO;
import com.pcms.role.model.Role;
import com.pcms.role.service.RoleService;

/**
 * @author baotq
 * 
 */
@Controller
@RequestMapping("/roleController")
public class RoleController extends BaseControl {

	@Inject
	private RoleService roleService;

	@RequestMapping("/initMain")
	public String initMain(Model model) {
		return "/views/role/roleOperator.jsp";
	}

	@RequestMapping(value = "/getRoleInfos", method = RequestMethod.POST)
	@ResponseBody
	public List<Role> getRoleInfos(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("queryName");
		// String createTime = request.getParameter("createTime");
		Role role = new Role();
		role.setName(name);
		List<Role> list = roleService.query(role);
		return list;
	}

	@RequestMapping("/addRole")
	@ResponseBody
	public Object addRole(Role role) {
		// ID会在数据库自动生成，这里设置一个伪值。
		role.setId(1L);
		role.setType("1");
		roleService.add(role);
		Map<String, String> map = new HashMap<String, String>();
		map.put("returnCode", "OK");
		return map;
	}

	public Object checkBfUserMod(UserVO userVO) {
		return null;
	}

	@RequestMapping("/updRole")
	@ResponseBody
	public Object updRole(Role role) {
		boolean flag = roleService.update(role);
		Map<String, String> map = new HashMap<String, String>();
		if (flag) {
			map.put("returnCode", "OK");
		} else {
			map.put("returnCode", "ERROR");
			map.put("errorMsg", "delete error!");
		}
		return map;
	}

	@RequestMapping("/delRole")
	@ResponseBody
	public Object delRole(String id) {
		Role role = new Role();
		role.setId(Long.parseLong(id));
		boolean flag = roleService.delete(role);
		Map<String, String> map = new HashMap<String, String>();
		if (flag) {
			map.put("returnCode", "OK");
		} else {
			map.put("returnCode", "ERROR");
			map.put("errorMsg", "delete error!");
		}
		return map;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		// e.printStackTrace();
		request.setAttribute("exception", e);
		return "/error.jsp";
	}
}
