package com.java1234.service;

import java.util.List;

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
	
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
		
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}
	
	@Test
	public void testInsertStudent(){
		logger.info("添加学生！");
		Student student=new Student("还会发哈",12);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}

	@Test
	public void testUpdateStudent(){
		logger.info("更新学生");
		Student student=new Student(3,"还会发哈",15);
		studentMapper.updateStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testDeleteStudent(){
		logger.info("删除学生");
		studentMapper.deleteStudent(6);
		sqlSession.commit();
	}
	
	@Test
	public void testFindStudentById(){
		logger.info("根据ID查询学生");
		Student student=studentMapper.getStduentById(1);
		System.out.println(student);
	}
	
	/*使用结果集映射*/
	@Test
	public void testFindStudents(){
		logger.info("遍历所有学生");
		List<Student> studentList=studentMapper.findStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}
}




























