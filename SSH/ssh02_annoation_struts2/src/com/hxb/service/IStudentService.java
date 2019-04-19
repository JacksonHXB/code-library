package com.hxb.service;

import com.hxb.beans.Student;

public interface IStudentService {
	public void addStudent(Student student);
	public Student findStudentById(int id);
}
