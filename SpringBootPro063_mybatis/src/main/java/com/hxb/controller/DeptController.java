package com.hxb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.bean.Department;
import com.hxb.bean.Employee;
import com.hxb.mapper.DepartmentMapper;
import com.hxb.mapper.EmployeeMapper;


@RestController
public class DeptController {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	/*根据ID查询部门---http://localhost:8080/dept/1*/
	@GetMapping("/dept/{id}")
	public Department getDepartment(@PathVariable("id") Integer id){
		return departmentMapper.getDeptById(id);
	}
	
	/*插入部门---http://localhost:8080/dept?departmentName=董事会*/
	@GetMapping("/dept")
	public Department insertDept(Department department){
		departmentMapper.insertDept(department);
		return department;
	}
	
	/*查询员工*/
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id") Integer id){
		return employeeMapper.getEmpById(id);
	}
}























































