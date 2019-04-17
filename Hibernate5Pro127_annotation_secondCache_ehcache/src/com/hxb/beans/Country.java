package com.hxb.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

//����
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)//��ʾ��ǰ��Ϊ������
public class Country {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="native")
	private Integer cid;
	
	private String cname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="countryId")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)//��ʾ��ǰΪ���ϻ������
	private Set<Minister> ministers;
	
	public Country(){
		ministers = new HashSet<Minister>();
	}
	public Country(String cname) {
		this();//��new��Countryʱ���Ϳ���ֱ�Ӵ����������
		this.cname = cname;
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
	public Set<Minister> getMinisters() {
		return ministers;
	}
	public void setMinisters(Set<Minister> ministers) {
		this.ministers = ministers;
	}
	
//	@Override
//	public String toString() {
//		return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
//	}
}
