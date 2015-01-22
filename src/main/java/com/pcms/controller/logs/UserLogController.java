/**
 * 
 */
package com.pcms.controller.logs;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcms.common.base.controller.BaseControl;
import com.pcms.model.logs.service.UserLogService;
import com.pcms.model.logs.vo.UserLogVO;

/**
 * @Description: TODO
 * @author by mizh
 * @date 2015-1-22 下午5:22:32
 *
 */
@Controller
@RequestMapping("/userLogController")
public class UserLogController extends BaseControl {
	@Inject
	private UserLogService userLogService;
	
	@RequestMapping("/userLogAdd")
	@ResponseBody
    public Object userLogAdd(UserLogVO userLogVO) {
		
        userLogService.addUserLogs(userLogVO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("returnCode", "OK");
        return map;
    }

	/* (non-Javadoc)
	 * @see com.pcms.common.base.controller.BaseControl#initMain(org.springframework.ui.Model)
	 */
	@Override
	public String initMain(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
}
