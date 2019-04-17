package com.hxb.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hxb.beans.Student;
/*
 * ����JdbcTmplateΪ������JDBCTemlateֻ�Ƕ����ģ���˲���д���������ʽ
 * */
public class StudentDaoImpl2 extends JdbcDaoSupport implements IStudentDao{
	
	//��JdbcTemplateֻ����һ��
	private JdbcTemplate jt;
	
	public StudentDaoImpl2() {
		jt = this.getJdbcTemplate();
	}

	/*�����û�*/
	@Override
	public void insertStudent(Student student) {
		String sql = "insert into tb_student(name, age) values(?,?)";
		jt.update(sql, student.getName(), student.getAge());
	}

	/*ɾ���û�*/
	@Override
	public void deleteStudentById(int id) {
		String sql = "delete from tb_student where id=?";
		jt.update(sql, id);
	}

	/*�޸��û�*/
	@Override
	public void updateStudent(Student student) {
		String sql = "update tb_student set name=?,age=? where id=?";
		jt.update(sql, student.getName(), student.getAge(), student.getId());
	}

	@Override
	public List<String> selectAllStudentsNames() {
		String sql = "select name from tb_student";
		return jt.queryForList(sql, String.class);
	}

	@Override
	public String selectStudentNameById(int id) {
		String sql = "select name from tb_student where id=?";
		return jt.queryForObject(sql, String.class, id);
	}

	@Override
	public List<Student> queryAll() {
		String sql = "select id,name,age from tb_student";
		//����rowMapper��������Է�װ�ɶ���
		return jt.query(sql, new StudentRowMapper());
	}

	@Override
	public Student selectStudentById(int id) {
		String sql = "select id,name,age from tb_student where id=?";
		return jt.queryForObject(sql, new StudentRowMapper(), id);
	}
}





























