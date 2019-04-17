package com.hxb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hxb.beans.Student;

/*ʵ�ֲ�ѯ�����ӳ��ɶ���*/
public class StudentRowMapper implements RowMapper<Student> {

	/*
	 * rs: ����ѯ���ܵĽ�����󣬿�ܻ��Զ���������������ÿһ�α�����һ�����ݣ����ᱻ��ŵ����������rs�����С�Ҳ����˵����rs�������һ�����ݣ����������в�ѯ����������Ƕ���˵��ֻҪ��ִ�е������������˵�������rs�����ǿ�
	 * */
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		return student;
	}

}





























