/**
 * 
 */
package com.pcms.model.dept.mapper;

import java.util.List;
import java.util.Map;

import com.pcms.model.SqlMapper;
import com.pcms.model.dept.vo.DeptVO;

/**
 * @author zhuming
 *
 */
public interface DeptMapper extends SqlMapper{
	
	public List getAllDepts();
	
	public List queryDeptByProperty(Map<String,Object> entity);
    
    public void addDept(DeptVO userVO);

    public void editDept(DeptVO userVO);

    public void removeDept(DeptVO userVO);

}
