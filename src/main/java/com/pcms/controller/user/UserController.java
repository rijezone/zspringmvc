/**
 * 
 */
package com.pcms.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcms.model.user.service.UserService;
import com.pcms.model.user.vo.UserVO;

/**
 * @author zhuming
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping("/initMain")
    public String initMain(Model model) {
        return "/operator.jsp";
    }
	
	@RequestMapping(value="/getUsersInJSON")  
    public @ResponseBody List<UserVO> getUsersInJSON(@RequestParam String queryName) {  
		System.out.println(queryName);
		Map<String,String> map = new HashMap<String,String>();
		map.put("queryName", "%"+queryName+"%");
        List<UserVO> list = userService.queryUsers(map);  
        return list;  
    } 
	
	@RequestMapping("/userAdd")
	@ResponseBody
    public Object userAdd(UserVO userVO) {
        System.out.println(userVO);
        boolean flag = userService.addUser(userVO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("returnCode", "OK");
        return map;
    }
	
	public Object checkBfUserMod(UserVO userVO){
		return null;
	}
	
	@RequestMapping("/userMod")
	@ResponseBody
    public Object userMod(UserVO userVO) {
        System.out.println(userVO);
        boolean flag = userService.editUser(userVO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("returnCode", "OK");
        return map;
    }
	
	@RequestMapping("/userDel")
	@ResponseBody
    public Object userDel(String userId) {
		UserVO userVO = new UserVO();
		userVO.setUserId(Integer.parseInt(userId));
        boolean flag = userService.removeUser(userVO);
        Map<String,String> map = new HashMap<String,String>();
        if(flag){
        	map.put("returnCode", "OK");
        }else{
        	map.put("returnCode", "ERROR");
        	map.put("errorMsg", "delete error!");
        }
        
        return map;
    }
  
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, HttpServletRequest request) {
        //e.printStackTrace();
        request.setAttribute("exception", e);
        return "/error.jsp";
    }
}
