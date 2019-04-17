package com.hxb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;

@SuppressWarnings("all")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		Student student = new Student(name, age);
		
		/*��ȡSpring������������������ʱ�Զ�����һ�Σ��Ͳ���Ҫʹ�����
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		*/
		ApplicationContext ac = (ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		System.out.println(ac);
		
		
		/*��ȡService����*/
		IStudentService service = (IStudentService)ac.getBean("studentService");
		
		/*����Service��addStudent()��ɲ���*/
		service.addStudent(student);
		
		req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
	}
}




















