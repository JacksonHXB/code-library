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

public class StudentTest2 {
	
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

	/*添加学生*/
	@Test
	public void testAdd() {
		logger.info("添加学生");
		Student student=new Student("王五",13);
		studentMapper.add(student);
		sqlSession.commit();
	}
	
	/*修改学生*/
	@Test
	public void testUpdate(){
		logger.info("修改学生");
		Student student=new Student(80,"王武",12);
		studentMapper.update(student);
		sqlSession.commit();
	}
	
	/*删除学生*/
	@Test
	public void testDelete(){
		logger.info("删除学生");
		studentMapper.delete(6);
		sqlSession.commit();
	}
	
	/*通过ID查找学生*/
	@Test
	public void testFindById(){
		logger.info("通过ID查找学生");
		Student student=studentMapper.findById(1);
		System.out.println(student.toString());
	}
	
	/*查找所有学生*/
	@Test
	public void testFind(){
		logger.info("查找所有学生");
		List<Student> studentList=studentMapper.find();
		for(Student s:studentList){
			System.out.println(s);
		}
	}

}










