package com.hxb.dao;

import com.hxb.beans.Student;

public interface IStudentDao {
	public void insertStudent(Student student);
	public Student selectStudentById(int id);
}
