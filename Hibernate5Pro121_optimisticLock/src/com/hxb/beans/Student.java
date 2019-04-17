package com.hxb.beans;

public class Student {
	private Integer id;
	private String name;
	private int age;
	private double score;
	
	private int sversion;//增加版本号，实现乐观锁
	
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
	public int getSversion() {
		return sversion;
	}
	public void setSversion(int sversion) {
		this.sversion = sversion;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}






























































































































