package com.java1234.mappers;

import java.util.List;
import java.util.Map;

import com.java1234.model.Student;

public interface StudentMapper {
	
	/*if条件:查询学生*/
	public List<Student> queryStudents(Map<String,Object> map);
	
	/*choose条件*/
	public List<Student> queryStudents2(Map<String,Object> map);
	
	/*where语句*/
	public List<Student> queryStudents3(Map<String,Object> map);
	
	/*trim条件*/
	public List<Student> queryStudents4(Map<String,Object> map);
	
	/*foreach条件*/
	public List<Student> queryStudents5(Map<String,Object> map);
	
	/*set对象*/
	public int updateStudent(Student student);
}












































