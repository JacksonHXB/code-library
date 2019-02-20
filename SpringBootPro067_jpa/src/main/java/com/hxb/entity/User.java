package com.hxb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//使用JPA注解配置映射关系
@Entity			//告诉JPA这是一个实体类
@Table(name="tb_user")   //指定与哪个数据表对应，如果省略就是类名小写user
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自增组件
	private Integer id;
	
	@Column(name="last_name",length=50)//如果省略列名就是属性名
	private String lastName;
	
	@Column
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}



































