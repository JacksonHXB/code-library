package com.hxb.di05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("all")
public class Some {
	private School[] schools;
	private String[] myStrs;
	private List<String> myList;
	private Set<String> mySet;
	private Map<String, Object> myMap;
	private Properties myPros;
	public void setSchools(School[] schools) {
		this.schools = schools;
	}
	public void setMyStrs(String[] myStrs) {
		this.myStrs = myStrs;
	}
	public void setMyList(List<String> myList) {
		this.myList = myList;
	}
	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	public void setMyMap(Map<String, Object> myMap) {
		this.myMap = myMap;
	}
	public void setMyPros(Properties myPros) {
		this.myPros = myPros;
	}
	@Override
	public String toString() {
		return "Some [\nschools=" + Arrays.toString(schools)+ ",\nmyStrs=" + Arrays.toString(myStrs) + ",\nmyList="
				+ myList + ",\nmySet=" + mySet + ",\nmyMap=" + myMap + ",\nmyPros=" + myPros + "\n]";
	}
}
