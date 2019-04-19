package com.hxb.handlers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;

public class StudentController implements Controller {

	private IStudentService service;
	
	public void setService(IStudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String ageStr=request.getParameter("age");
		Integer age=Integer.valueOf(ageStr);
		Student student=new Student(name,age);
		
		//调用service中的方法
		service.addStudent(student);
		
		return new ModelAndView("/welcome.jsp");
	}
}
