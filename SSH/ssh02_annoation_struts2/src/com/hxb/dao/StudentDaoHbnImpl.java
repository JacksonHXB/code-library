package com.hxb.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxb.beans.Student;

@Repository("studentDao")
public class StudentDaoHbnImpl implements IStudentDao{

	@Resource(name="studentDao")//byName��ʽע��,Ҳ����
	private SessionFactory sessionFactory;

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)//��Щ��Ĭ��ֵ������ȥ��
	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	@Transactional(readOnly=true)//����readOnly�����ò�ѯ����
	public Student selectStudentById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class,id);
	}
}































































































































