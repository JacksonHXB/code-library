package com.hxb.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="native")
	private Integer id;
	private String name;
	private int age;
	
	public Student(){}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
}
