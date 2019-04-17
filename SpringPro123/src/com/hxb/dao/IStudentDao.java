package com.hxb.dao;

import java.util.List;

import com.hxb.beans.Student;

public interface IStudentDao {
	void insertStudent(Student student);
	
	void deleteStudentById(int id);
	
	void updateStudent(Student student);
	
	List<Student> queryAll();
	
	Student selectStudentById(int id);
}
































































