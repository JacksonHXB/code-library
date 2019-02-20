package com.hxb.SpringBootPro009_config.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*将配置文件中配置的每一个属性的至，映射到这个组件中
@ConfigurationProperties:告诉SpringBoot将本类中所有属性和配置文件中相关的配置进行绑定
	prefix="person":将配置文件中哪个下面的所有属性进行一一映射
	只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
*/
@Component
@ConfigurationProperties(prefix="person")
//@Validated
//@PropertySource(value={"classpath:person.properties"})//导入自定义的配置文件
public class Person {
//	@Value("${person.last-name}")在配置中写last-name时，使用@Value必须是配置中的名称，而@ConfigurationProperties可以使用lastName来时表示
//	@Email这个用于@ConfigurationProperties的校验
	private String lastName;
//	@Value("#{11*2}")
	private Integer age;
//	@Value("true")
	private Boolean boss;
	private Date birth;
	
	private Map<String,Object> maps;
	private List<Object> lists;
	private Dog dog;
	
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps="
				+ maps + ", lists=" + lists + ", dog=" + dog + "]";
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getBoss() {
		return boss;
	}
	public void setBoss(Boolean boss) {
		this.boss = boss;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
}
