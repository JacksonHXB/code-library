package com.hxb.dao;

import org.hibernate.SessionFactory;
import com.hxb.beans.Student;

public class StudentDaoHbnImpl implements IStudentDao{

	//使用set方法注入sessionFactory
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public Student selectStudentById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class,id);
//		return sessionFactory.getCurrentSession().load(Student.class,id);  这个会报错,因为这里只是返回的是一个代理
	}
}































































































































