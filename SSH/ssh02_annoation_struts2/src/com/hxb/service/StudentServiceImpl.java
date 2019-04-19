package com.hxb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	
	@Resource//byTypeע��
//	@Autowired//Ҳ����
	private IStudentDao dao;
	
	//������Ա���
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}
}































