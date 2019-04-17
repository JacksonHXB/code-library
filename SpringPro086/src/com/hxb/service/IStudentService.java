package com.hxb.service;

import java.util.List;

import com.hxb.beans.Student;

public interface IStudentService {
	//���ѧ��
	void addStudent(Student student);
	void removeStudentById(int id);
	void modifyStudent(Student student);
	
	List<String> queryAllStudentsNames();
	String queryStudentNameById(int id);
	
	//��ѯ���е�ѧ��
	List<Student> queryAll();
	
	//����ID��ѯѧ��
	Student queryStudentById(int id);
}





























