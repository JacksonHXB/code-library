package com.hxb.service;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

public class StudentServiceImpl implements IStudentService{
	
	//��Spring����ע�룬������Ҫ�����Set����
	private IStudentDao dao;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}
}































