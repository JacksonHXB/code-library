package com.hxb.handlers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;

@Controller
@RequestMapping("/test")
public class StudentController{
	
	@Resource(name="studentService")
	private IStudentService service;
	
	/*����ʹ����һ��ע�ⷽʽ
		@Autowired
		@Qualifier("studentService")
		private IStudentService service;
	*/
	
	@RequestMapping("/register.do")
	public String doRegister(String name,int age) throws Exception {
		Student student=new Student(name,age);
		
		//����service�еķ���
		service.addStudent(student);
		
		return "/welcome.jsp";
	}
}

































