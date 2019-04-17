package com.hxb.di01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myHome")
public class Home {
	@Value("วเท๏")
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Home [name=" + name + "]";
	}
}
