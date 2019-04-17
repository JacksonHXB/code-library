package com.hxb.service;

import java.util.ArrayList;
import java.util.List;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

/*Service��*/
public class StudentServiceImpl implements IStudentService{
	private IStudentDao dao;

	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public List<String> queryAllStudentsNames() {
		List<String> names = new ArrayList<String>();
		List<Student> students = this.queryAll();
		for(Student student:students){
			names.add(student.getName());
		}
		return names;
	}

	@Override
	public String queryStudentNameById(int id) {
		Student student = this.queryStudentById(id);
		return student.getName();
	}

	@Override
	public List<Student> queryAll() {
		return dao.queryAll();
	}

	@Override
	public Student queryStudentById(int id) {
		return dao.selectStudentById(id);
	}

	@Override
	public void removeStudentById(int id) {
		dao.deleteStudentById(id);
	}

	@Override
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

}
