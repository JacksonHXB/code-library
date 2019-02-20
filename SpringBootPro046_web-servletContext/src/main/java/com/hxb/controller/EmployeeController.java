package com.hxb.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hxb.dao.DepartmentDao;
import com.hxb.dao.EmployeeDao;
import com.hxb.entity.Department;
import com.hxb.entity.Employee;

@Controller
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	DepartmentDao departmentDao;
	
	/*查询员工列表*/
	@GetMapping("/emps")
	public String list(Model model){
		logger.info("已经开始查询，准备跳转页面！");
		
		Collection<Employee> employees = employeeDao.getAll();
		
		/*放在请求域中*/
		model.addAttribute("emps",employees);
		
		return "emp/list";//thymeleaf会默认拼字符串classpath:/templates/xxx.html
	}
	
	/*跳转至员工添加页面*/
	@GetMapping("/emp")
	public String toAddPage(Model model){
		Collection<Department> departments = departmentDao.getDepartments();
		
		model.addAttribute("depts",departments);
		
		return "emp/add";
	}
	
	/*添加员工*/
	/*SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的属性名是一样的*/
	@PostMapping("/emp")
	public String addEmp(Employee employee){
		
		employeeDao.save(employee);
		
		//redirect:表示重定向一个地址。/代表当前项目路径+
		//forward:表示转发到一个地址
		return "redirect:/emps";
	}
	
	/*跳转至修改页面，查出当前员工，在页面回显*/
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model){
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp",employee);	
		//页面要显示所有的部门列表
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		//回到修改页面（add是一个修改添加二合一页面）
		return "emp/add";
	}
	
	/*员工修改,需要提交员工ID*/
	@PutMapping("/emp")
	public String updateEmployee(Employee employee){
		System.out.println("修改员工数据："+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/*员工删除*/
	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id){
		System.out.println("点击删除！");
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
































