package com.hxb.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

//部长
@Entity
public class Minister {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx", strategy="native")
	private Integer mid;
	private String mname;
	@ManyToOne(targetEntity=Country.class,cascade=CascadeType.ALL)//这里只能使用all
	@JoinColumn(name="countryId")//外键
	private Country country;
	
	public Minister() {}
	public Minister(String mname) {
		this.mname = mname;
	}
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + "]";
	}
}













































