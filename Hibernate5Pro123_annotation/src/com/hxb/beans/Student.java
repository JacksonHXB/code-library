package com.hxb.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity//��Ϊ�õ�jpa��ע�⣬������Hibernate�Լ���ע�⣬�������Ա�����һ��ʵ��
@Table(name="tb_student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tid")
	private Integer id;
	
	@Basic//��ʾ��ǰ���Խ����־û������ݿ�
	@Column(name="tname")
	private String name;
	
	@Basic
	@Column(name="tage")
	private int age;
	
	@Transient //��ʾ��ǰ���Բ�д�뵽DB��
	private double score;
	
	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student(String name, int age, double score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}






























































































































