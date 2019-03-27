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

public class GradeTest {
	
	private static Logger logger=Logger.getLogger(GradeTest.class);
	private SqlSession sqlSession=null;
	GradeMapper gradeMapper=null;
	
	/*测试方法执行前调用*/
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		gradeMapper=sqlSession.getMapper(GradeMapper.class);
		
	}
	
	/*测试方法执行后调用*/
	@After
	public void tearDown() throws Exception {
		//关闭sqlSession
		sqlSession.close();
	}
	
	/*查找年级（学生）*/
	@Test
	public void testFindGradeWithStudents(){
		logger.info("查找年级(带学生)");
		Grade grade=gradeMapper.findById(1);
		System.out.println(grade.getStudents().size());
	}
}




























