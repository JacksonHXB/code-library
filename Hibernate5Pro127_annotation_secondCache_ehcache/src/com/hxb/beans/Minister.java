package com.hxb.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

//部长
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Minister {
	@Id
	@GeneratedValue(generator="xxx")
	@GenericGenerator(name="xxx",strategy="native")
	private Integer mid;
	
	private String mname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="countryId")
	private Country country;	//关联属性
	
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
	
	//双向关联在定义toString()时，要求只有一方可以输出对方即可
	//若双方均输出对象，则会形成递归调用，会出错
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + "]";
	}
}













































