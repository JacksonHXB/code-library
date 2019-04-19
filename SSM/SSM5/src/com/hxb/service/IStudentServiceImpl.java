package com.hxb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

@Service("studentService")
public class IStudentServiceImpl implements IStudentService {
	
	//也有两种方式，而set方法也可以留下
	@Resource(name="IStudentDao")
	private IStudentDao dao;

	//这里可以添加参数，如果没有添加就是默认的
	@Transactional
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}
}
