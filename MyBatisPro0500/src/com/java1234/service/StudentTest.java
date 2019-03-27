package com.java1234.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.GradeMapper;
import com.java1234.mappers.StudentMapper;
import com.java1234.model.Grade;
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
	
	
	/*查找学生并且携带年级名称*/
	@Test
	public void testFindStudentWithGrade(){
		logger.info("查找学生（带地址）");
		Student student=studentMapper.findStudentWithGrade(1);
		System.out.println(student.getGrade().getGradeName());
	}
	
}




























