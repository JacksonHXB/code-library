package com.java1234.mappers;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.java1234.model.Student;

public interface StudentMapper {
	
	@Update("update tb_student set name=#{name},age=#{age} where id=#{id}")
	public int updateStudent(Student student);
	
	@Insert("insert into tb_student values(null,#{name},#{age})")
	public int insertStudent(Student student);
	
	@Delete("delete from tb_student where id=#{id}")
	public int deleteStudent(int id);
	
	@Select("select * from tb_student where id=#{id}")
	public Student getStduentById(Integer id);
	
	@Select("select * from tb_student")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age")
	})
	public List<Student> findStudents();
	
}












































