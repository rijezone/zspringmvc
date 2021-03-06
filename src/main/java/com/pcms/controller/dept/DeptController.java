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
	
	@RequestMapping("/initSelectDept")
	public String initSelectDept(Model model) {
		return "/views/dept/deptSelect.jsp";
	}

	@RequestMapping(value="/getDatasInJSON",method=RequestMethod.POST)  
	@ResponseBody
	public  List<DeptVO> getDatasInJSON(HttpServletRequest request, HttpServletResponse response) {
		String queryName = request.getParameter("queryName");
		String createTime = request.getParameter("createTime");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("queryName",queryName==null?null:"%"+queryName+"%");
		map.put("createTime", createTime);
		Integer rowsBegin = (Integer.parseInt(request.getParameter("page"))-1)*Integer.parseInt(request.getParameter("rows"));
		map.put("pageSize", Integer.parseInt(request.getParameter("rows")));
		map.put("curPage", request.getParameter("page"));
		map.put("rowsBegin", rowsBegin);
		List<DeptVO> list = deptService.queryObjects(map);  
		return list; 
	}
	
	@RequestMapping("/add")
	@ResponseBody
    public Object add(DeptVO deptVO) {
        System.out.println(deptVO);
        boolean flag = deptService.addObject(deptVO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("returnCode", "OK");
        return map;
    }
	@RequestMapping("/mod")
	@ResponseBody
    public Object mod(DeptVO deptVO) {
        System.out.println(deptVO);
        boolean flag = deptService.editObject(deptVO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("returnCode", "OK");
        return map;
    }
	
	@RequestMapping("/del")
	@ResponseBody
    public Object del(String deptId) {
		DeptVO deptVO = new DeptVO();
        Map<String,String> map = new HashMap<String,String>();
        boolean flag = false;
        if(deptId!=null&&!deptId.isEmpty()){
    		deptVO.setDeptId(Integer.parseInt(deptId));
            flag = deptService.removeObject(deptVO);
            if(flag){
            	map.put("returnCode", "OK");
            }else{
            	map.put("returnCode", "ERROR");
            	map.put("errorMsg", "delete error!");
            } 	
        }else{
        	map.put("errorMsg", "deptId is empty");
        }
        return map;
    }
}
