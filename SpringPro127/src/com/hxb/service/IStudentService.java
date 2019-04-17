package com.hxb.service;

import java.util.List;

import com.hxb.beans.Student;

public interface IStudentService {
	//添加学生
	void addStudent(Student student);
	void removeStudentById(int id);
	void modifyStudent(Student student);
	
	List<String> queryAllStudentsNames();
	String queryStudentNameById(int id);
	
	//查询所有的学生
	List<Student> queryAll();
	
	//根据ID查询学生
	Student queryStudentById(int id);
}





























