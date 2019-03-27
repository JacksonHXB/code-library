package com.java1234.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
	
	private static Logger logger=Logger.getLogger(StudentTest2.class);
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
	
	/*插入学生，带BLOB,CLOB*/
	@Test
	public void testInsertStudent(){
		logger.info("添加学生");
		Student student=new Student();
		student.setName("张三四");
		student.setAge(18);
		student.setRemark("很长的文本");
		byte[] pic=null;
		try{
			File file=new File("c://boy.jpg");
			InputStream inputStream=new FileInputStream(file);
			pic=new byte[inputStream.available()];
			inputStream.read(pic);
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		student.setPic(pic);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}
	
	/*查找学生，并输出图片*/
	@Test
	public void testGetStudentById(){
		logger.info("通过ID查找学生");
		Student student=studentMapper.getStudentById(4);
		System.out.println(student);
		byte[] pic=student.getPic();
		try {
			File file=new File("d://boy2.jpg");
			OutputStream outputStream=new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*传入多个参数*/
	@Test
	public void testQueryStudents(){
		logger.info("传入多个参数");
		List<Student> sutdentList=studentMapper.queryStudents("%张%", 12);
		System.out.println(sutdentList.size());
	}
}




























