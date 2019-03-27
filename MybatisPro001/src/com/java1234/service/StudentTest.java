package com.java1234.service;

import org.apache.ibatis.session.SqlSession;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest {
	public static void main(String[] args) {
		//获取SqlSession对象
		SqlSession sqlSession=SqlSessionFactoryUtil.opneSession();
		//获取映射器
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=new Student("栗色",11);
		int result=studentMapper.add(student);
		if(result>0){
			System.out.println("添加成功！");
		}
	}
}



















