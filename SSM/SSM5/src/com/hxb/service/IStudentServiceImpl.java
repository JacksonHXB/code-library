package com.hxb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxb.beans.Student;
import com.hxb.dao.IStudentDao;

@Service("studentService")
public class IStudentServiceImpl implements IStudentService {
	
	//Ҳ�����ַ�ʽ����set����Ҳ��������
	@Resource(name="IStudentDao")
	private IStudentDao dao;

	//���������Ӳ��������û����Ӿ���Ĭ�ϵ�
	@Transactional
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}
}
