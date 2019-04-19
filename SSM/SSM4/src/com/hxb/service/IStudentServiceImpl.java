package com.hxb.service;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

public class IStudentServiceImpl implements IStudentService {

	private IStudentDao dao;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}
}
