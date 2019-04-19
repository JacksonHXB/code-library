package com.hxb.dao;

import org.apache.ibatis.annotations.Insert;

import com.hxb.beans.Student;

public interface IStudentDao {
	
	@Insert("insert into tb_student(name,age) values(#{name},#{age})")
	public void insertStudent(Student student);
	
}






































