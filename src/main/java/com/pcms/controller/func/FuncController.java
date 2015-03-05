/**
 * 
 */
package com.pcms.controller.func;

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
import com.pcms.model.func.service.FuncService;
import com.pcms.model.func.vo.FuncVO;

/**
 * 
 * This class is used for ...
 * 
 * @author Pelo
 * @version 1.0, 2015年3月4日 上午11:21:55
 */
@Controller
@RequestMapping("/funcController")
public class FuncController extends BaseControl {

	@Inject
	private FuncService funcService;

	@RequestMapping("/initMain")
	public String initMain(Model model) {

		return "/views/func/func.jsp";
	}

	@RequestMapping("/initSelectFunc")
	public String initSelectFunc(Model model) {
		return "/views/func/funcSelect.jsp";
	}

	@RequestMapping(value = "/getDatasInJSON", method = RequestMethod.POST)
	@ResponseBody
	public List<FuncVO> getDatasInJSON(HttpServletRequest request,
			HttpServletResponse response) {
		String queryName = request.getParameter("queryName");
		String createTime = request.getParameter("createTime");
		Map<String, String> map = new HashMap<String, String>();
		map.put("queryName", queryName == null ? null : "%" + queryName + "%");
		map.put("createTime", createTime);
		map.put("pageSize", request.getParameter("rows"));
		map.put("curPage", request.getParameter("page"));
		List<FuncVO> list = funcService.queryFuncs(map);
		return list;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Object add(FuncVO funcVO) {
		System.out.println(funcVO);
		boolean flag = funcService.addFunc(funcVO);
		Map<String, String> map = new HashMap<String, String>();
		map.put("returnCode", "OK");
		return map;
	}

	@RequestMapping("/mod")
	@ResponseBody
	public Object mod(FuncVO funcVO) {
		System.out.println(funcVO);
		boolean flag = funcService.editFunc(funcVO);
		Map<String, String> map = new HashMap<String, String>();
		map.put("returnCode", "OK");
		return map;
	}

	@RequestMapping("/del")
	@ResponseBody
	public Object del(String funcId) {
		FuncVO funcVO = new FuncVO();
		funcVO.setId(Integer.parseInt(funcId));
		boolean flag = funcService.removeFunc(funcVO);
		Map<String, String> map = new HashMap<String, String>();
		if (flag) {
			map.put("returnCode", "OK");
		} else {
			map.put("returnCode", "ERROR");
			map.put("errorMsg", "delete error!");
		}
		return map;
	}
}
