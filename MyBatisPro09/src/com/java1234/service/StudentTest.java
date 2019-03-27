package com.java1234.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest {
	
	private static Logger logger=Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession=null;
	StudentMapper studentMapper=null;
	
	/*测试方法执行前调用*/
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
		
	}
	
	/*测试方法执行后调用*/
	@After
	public void tearDown() throws Exception {
		//关闭sqlSession
		sqlSession.close();
	}
	
	/*逻辑分页查询*/
	@Test
	public void testFindStudents(){
		logger.info("查询学生");
		//相当于start
		int offest=0;
		//相当于每页显示的数量
		int limit=3;
		RowBounds rowBounds=new RowBounds(offest,limit);
		List<Student> studentList=studentMapper.findStudents(rowBounds);
		System.out.println(studentList.size());
	}
	
	/*物理分页查询*/
	@Test
	public void testFindStudents2(){
		logger.info("查询学生");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start",0);
		map.put("size",2);
		List<Student> studentList=studentMapper.findStudents2(map);
		for (Student student:studentList) {
			System.out.println(student);
		}
	}
}




























