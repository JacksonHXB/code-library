package com.hxb.mapper;

import com.hxb.bean.Employee;

/*@mapper或者@MapperScan将接口扫描装配到容器中*/
public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public void insertEmp(Employee employee);
}











































