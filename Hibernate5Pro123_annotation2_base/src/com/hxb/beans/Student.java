package com.hxb.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_student")
public class Student {
	
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="native")//�Զ���������
	private Integer id;
	//��ʾ��ǰ���Խ����־û������ݿ�,�����Basic���Բ���д������Ĭ��д�����ݿ���
	//Column����д�Ļ������ֶ�������������һ�µ�
	private String name;
	private int age;
	@Transient
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






























































































































