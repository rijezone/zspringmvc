package com.pcms.model.func.dao.mapper;

import java.util.List;
import java.util.Map;

import com.pcms.model.SqlMapper;
import com.pcms.model.func.vo.FuncVO;

public interface FuncMapper extends SqlMapper {
	public List getAllFuncs();

	public List queryFuncByProperty(Map<String, Object> entity);

	public void addFunc(FuncVO FuncVO);

	public void editFunc(FuncVO FuncVO);

	public void removeFunc(FuncVO FuncVO);
}
