package com.hxb.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hxb.beans.Student;

public class StudentDaoImpl extends JdbcDaoSupport implements IStudentDao{

	/*增加用户*/
	@Override
	public void insertStudent(Student student) {
		String sql = "insert into tb_student(name, age) values(?,?)";
		this.getJdbcTemplate().update(sql, student.getName(), student.getAge());
	}

	/*删除用户*/
	@Override
	public void deleteStudentById(int id) {
		String sql = "delete from tb_student where id=?";
		this.getJdbcTemplate().update(sql, id);
	}

	/*修改用户*/
	@Override
	public void updateStudent(Student student) {
		String sql = "update tb_student set name=?,age=? where id=?";
		this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getId());
	}

	@Override
	public List<String> selectAllStudentsNames() {
		String sql = "select name from tb_student";
		return this.getJdbcTemplate().queryForList(sql, String.class);
	}

	@Override
	public String selectStudentNameById(int id) {
		String sql = "select name from tb_student where id=?";
		return this.getJdbcTemplate().queryForObject(sql, String.class, id);
	}

	@Override
	public List<Student> queryAll() {
		String sql = "select id,name,age from tb_student";
		//这里rowMapper参数项可以封装成对象
		return this.getJdbcTemplate().query(sql, new StudentRowMapper());
	}

	@Override
	public Student selectStudentById(int id) {
		String sql = "select id,name,age from tb_student where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), id);
	}
}





























