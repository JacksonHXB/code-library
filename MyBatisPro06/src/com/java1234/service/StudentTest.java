package com.java1234.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	/*查找学生（带if条件）*/
	@Test
	public void testQueryStudents(){
		logger.info("查找学生（带条件）");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("gradeId",1);
		map.put("name","%李%");
		map.put("age",11);
		List<Student> studentList=studentMapper.queryStudents(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	/*查找学生（带choose条件）*/
	@Test
	public void testQueryStudents2(){
		logger.info("查找学生（带条件）");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchBy","name");
		map.put("name","%李%");
		map.put("age",11);
		List<Student> studentList=studentMapper.queryStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	/*where语句*/
	@Test
	public void testQueryStudents3(){
		logger.info("查找学生（带条件）");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchBy","name");
		map.put("name","%李%");
		map.put("age",11);
		List<Student> studentList=studentMapper.queryStudents3(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	/*trim语句*/
	@Test
	public void testQueryStudents4(){
		logger.info("查找学生（带条件）");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchBy","name");
		map.put("name","%李%");
		map.put("age",11);
		List<Student> studentList=studentMapper.queryStudents4(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	/*foreach语句*/
	@Test
	public void testQueryStudents5(){
		logger.info("查找学生（带条件）");
		Map<String,Object> map=new HashMap<String,Object>();
		List<Integer> gradeIds=new ArrayList<Integer>();
		gradeIds.add(1);
		gradeIds.add(2);
		map.put("gradeIds",gradeIds);
		List<Student> studentList=studentMapper.queryStudents5(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	/*set语句*/
	@Test
	public void testUpdateStudent(){
		logger.info("更新学生");
		Student student=new Student();
		student.setId(1);
		student.setName("张三2");
		studentMapper.updateStudent(student);
		sqlSession.commit();
	}
}




























