package com.pcms.model.dept.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pcms.common.base.model.service.impl.BaseServiceImpl;
import com.pcms.model.BizException;
import com.pcms.model.dept.service.DeptService;
import com.pcms.model.user.dao.UserDao;
import com.pcms.model.user.vo.UserVO;

@Service
public class DeptServiceImpl extends BaseServiceImpl implements DeptService{
	@Inject
	private UserDao dao;

}
