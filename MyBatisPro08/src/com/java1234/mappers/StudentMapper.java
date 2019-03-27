package com.java1234.mappers;


import java.util.List;

import com.java1234.model.Student;

public interface StudentMapper {
	
	public int insertStudent(Student student);
	
	public Student getStudentById(Integer id);
	
	public List<Student> queryStudents(String name,int age);
}












































