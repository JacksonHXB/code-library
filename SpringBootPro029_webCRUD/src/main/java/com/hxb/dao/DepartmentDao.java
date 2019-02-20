package com.hxb.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hxb.entity.Department;

@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	static{
		departments = new HashMap<Integer, Department>();
		departments.put(101, new Department(101,"销售部"));
		departments.put(102, new Department(102,"财务部"));
		departments.put(103, new Department(103,"投资部"));
		departments.put(104, new Department(104,"金融部"));
		departments.put(105, new Department(105,"银行部"));
	}

	/*获取所有部门*/
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	/*根据ID获取部门*/
	public Department getDepartment(Integer id){
		return departments.get(id);
	}

}









































