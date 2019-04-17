package com.hxb.actions;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.hxb.beans.Student;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("all")
public class SomeAction {
	public String execute() {
		/*获取值栈*/
		String key = ServletActionContext.STRUTS_VALUESTACK_KEY;
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack)request.getAttribute(key);
		
		/*向值栈中显式放入数据*/
		//1，向root属性中直接放入无名对象
		Student student = new Student("张三", 23);
		vs.getRoot().push(student);
		
		//2，向值栈中直接放入无名对象，但实际也是放入到了其root属性中
		Student student2 = new Student("李四", 24);
		vs.push(student2);
		
		//3，向值栈中直接放入有名对象，即Map
		Student student3 = new Student("王五", 25);
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("student3", student3);
		vs.push(map);
		
		//4，向值栈中直接放入有名对象，跟其上本质上一致的
		Student student4 = new Student("王麻子", 26);
		vs.set("student4", student4);
		
		//5，将root当作是ArrayList放入数据
		Student student5 = new Student("田七", 27);
		vs.getRoot().add(student5);
		
		//获取值栈中下标为6的值，push每次放入是放在首位，而add则是放在末尾
		Student stu = (Student)vs.getRoot().get(6);
		System.out.println(stu);
		return "success";
	}
}
































































