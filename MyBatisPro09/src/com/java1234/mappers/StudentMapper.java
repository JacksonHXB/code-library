package com.java1234.mappers;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.java1234.model.Student;

public interface StudentMapper {

	/*逻辑分页查询*/
	public List<Student> findStudents(RowBounds rowBounds);
	
	/*物理分页*/
	public List<Student> findStudents2(Map<String,Object> map);
	
}












































