package com.hxb.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Course {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="native")
	private Integer cid;
	
	private String cname;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="courses")//需要放弃一方的维护权，否则会生成两张表
	private Set<Student> students;
	
	public Course(){
		students = new HashSet<Student>();
	}
	public Course(String cname) {
		this();
		this.cname = cname;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
}




































