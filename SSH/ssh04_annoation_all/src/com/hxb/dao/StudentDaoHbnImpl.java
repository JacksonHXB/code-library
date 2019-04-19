package com.hxb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxb.beans.Student;

@Repository
public class StudentDaoHbnImpl implements IStudentDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)//这些是默认值，可以去掉
	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	@Transactional(readOnly=true)//加上readOnly可以让查询更快
	public Student selectStudentById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class,id);
	}
}































































































































