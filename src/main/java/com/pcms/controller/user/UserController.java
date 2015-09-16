/**
 * 
 */
package com.pcms.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcms.common.base.controller.BaseControl;
import com.pcms.model.user.service.UserService;
import com.pcms.model.user.vo.UserVO;

/**
 * @author zhuming
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseControl{

    @Inject
    private UserService userService;

    @RequestMapping("/initMain")
    public String initMain(Model model) {
        return "/views/user/user.jsp";
    }
	
	@RequestMapping(value="/getUsersInJSON",method=RequestMethod.POST)  
    public @ResponseBody List<UserVO> getUsersInJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(page+"  "+rows);
		String queryName = request.getParameter("queryName");
		String createTime = request.getParameter("createTime");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("queryName",queryName==null?null:"%"+queryName+"%");
		map.put("createTime", createTime);
		Integer rowsBegin = (Integer.parseInt(request.getParameter("page"))-1)*Integer.parseInt(request.getParameter("rows"));
		map.put("pageSize", Integer.parseInt(request.getParameter("rows")));
		map.put("curPage", request.getParameter("page"));
		map.put("rowsBegin", rowsBegin);
        List<UserVO> list = userService.queryUsers(map);  
        return list;  
    } 
	
	@RequestMapping("/userAdd")
	@ResponseBody
    public Object userAdd(UserVO userVO) {
        String pWord = DigestUtils.md5Hex(userVO.getUserPass());
        userVO.setUserPass(pWord);
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
        Map<String,String> map = new HashMap<String,String>();
        boolean flag = false;
        if(userId!=null&&!userId.isEmpty()){
    		userVO.setUserId(Integer.parseInt(userId));
            flag = userService.removeUser(userVO); 
            if(flag){
            	map.put("returnCode", "OK");
            }else{
            	map.put("returnCode", "ERROR");
            } 
        }else{
        	map.put("errorMsg", "userId is empty!");
        }
          
        return map;
    }
}
