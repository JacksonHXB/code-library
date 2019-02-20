package com.hxb.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hxb.entity.Department;
import com.hxb.entity.Employee;

@Repository
public class EmployeeDao {
	
	private static Map<Integer, Employee> employees = null;
	private static Integer initId = 1006;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "黄小兵","1@qq.com",1, new Department(101,"销售部")));
		employees.put(1002, new Employee(1002, "李英才","2@qq.com",0, new Department(101,"销售部")));
		employees.put(1003, new Employee(1003, "张刚于","3@qq.com",0, new Department(101,"销售部")));
		employees.put(1004, new Employee(1004, "夏晓鹤","4@qq.com",1, new Department(101,"销售部")));
		employees.put(1005, new Employee(1005, "白云飞","5@qq.com",0, new Department(101,"销售部")));
	}
	
	/*增加员工到数据库*/
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	/*删除用户*/
	public void delete(Integer id){
		System.out.println("正在执行删除炒作@");
		employees.remove(id);
	}
	
	/*遍历页面*/
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	/*根据ID获取员工*/
	public Employee get(Integer id){
		return employees.get(id);
	}
}






























































































