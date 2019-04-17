package com.hxb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.junit.Test;

import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*准备测试数据*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			for (int i = 1; i < 11; i++) {
				Student student = new Student("n_" + i, 15+i, 85+i);
				session.save(student);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询所有,原生SQL查询*/
	@Test
	public void test01_SQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String sql = "select * from tb_student";
			SQLQuery sqlQuery = session.createSQLQuery(sql);//创建SQLQuery查询，查询的结果是一个Object数组，没有被封装
			List<Student> studentList = sqlQuery.addEntity(Student.class).list();//查询的结果通过映射文件，反射类，并封装成对象
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询所有,HQL查询*/
	@Test
	public void test01_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";//这里的是类名
			Query hqlQuery = session.createQuery(hql);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询所有,QBC查询*/
	@Test
	public void test01_QBC(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Criteria qbc = session.createCriteria(Student.class);
			List<Student> studentList = qbc.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询结果排序,原生SQL查询*/
	@Test
	public void test02_SQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String sql = "select * from tb_student order by tscore desc";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			List<Student> studentList = sqlQuery.addEntity(Student.class).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询结果排序,HQL查询*/
	@Test
	public void test02_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//在不使用类的别名的情况下，在HQL中直接使用字段名也是可以通过的。但若是使用"类别名.属性名"的形式，则不能使用字段名
			String hql = "from Student order by score desc";
			Query hqlQuery = session.createQuery(hql);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*查询结果排序,QBC查询*/
	/*查询结果排序,HQL查询*/
	@Test
	public void test02_QBC(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Criteria qbc = session.createCriteria(Student.class);
			List<Student> studentList = qbc.addOrder(Order.desc("score")).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*动态参数绑定,HQL查询方式一*/
	@Test
	public void test03_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>? and score<?";
			//这里的set方法，可以一直往下写
			Query hqlQuery = session.createQuery(hql)
									.setInteger(0, 20)
									.setDouble(1, 94);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*动态参数绑定,HQL查询方式二*/
	@Test
	public void test03_HQL2(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>:myAge and score<:myScore";//这里myAge，mySocre是别名
			Query hqlQuery = session.createQuery(hql)
									.setInteger("myAge", 20)
									.setDouble("myScore", 94);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*动态参数绑定,HQL查询方式三*/
	@Test
	public void test03_HQL3(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>? and score<?";
			//类型绝对要匹配,也可以使用方式二的HQL语句
			Query hqlQuery = session.createQuery(hql)
									.setParameter(0, 20)
									.setParameter(1, 94.0);//这里必须使用double类型，否则会报异常
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*分页查询,HQL查询*/
	@Test
	public void test04_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//selcet * from tb_student limit startIndex,pageSize
			String hql = "from Student";
			
			int pageno = 2;//第几页
			int pageSize = 3;//每页显示数目
			int startIndex = (pageno - 1) * pageSize;//起始位置
			List<Student> studentList = session.createQuery(hql)
											   .setFirstResult(startIndex)
											   .setMaxResults(pageSize)
											   .list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*模糊查询,HQL查询*/
	@Test
	public void test05_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where name like :myName";
			List<Student> studentList = session.createQuery(hql)
											   .setString("myName", "%张%")
											   .list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*唯一性查询,HQL查询*/
	@Test
	public void test06_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where name where id=:myId";
			Student student = (Student)session.createQuery(hql).setInteger("myId", 2).uniqueResult();
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*聚合函数查询,HQL查询*/
	@Test
	public void test07_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select count(*) from Student";
			Long count = (Long)session.createQuery(hql).uniqueResult();
			System.out.println("总共有：" + count + "条数据！");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*投影查询,HQL查询*/
	@Test
	public void test08_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select new Student(name,age) from Student";//创建对象并封装，这里需要带两个参数的构造器
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s.getName() +"  "+s.getAge());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*分组查询,HQL查询*/
	@Test//查询有多少个年龄段，并且每个处于年龄个数大于1
	public void test09_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select age from Student group by age having count(age) > 1";
			List<Student> studentList = session.createQuery(hql).list();
			System.out.println(studentList);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*使用list()查询所有,HQL查询*/
	//Query接口的list()方法不会从Session缓存中读取
	@Test
	public void test10_HQL_list(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//第一次查询
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			System.out.println("---------------------------------");
			//第二次查询
			List<Student> studentList2 = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*使用iterate()查询所有,HQL查询*/
	//iterate()的效率远远低于list()，主要是查询次数的问题，但是iterate有session缓存，第一次查询很慢，但是以后就相对较快,因为使用主键查询，而不是详情查询
	/*
		N+1问题：
			在缓存中查询N次，同时还需要到数据库中查询N次，其实质是2N+1，1则是又根据主键查询了一次
			解决方案：
				第一次查询放入Session，第二次使用iterate()
	*/
	@Test
	public void test10_HQL_iterate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//第一次查询
			Iterator<Student> studentItems = session.createQuery(hql).iterate();
			while(studentItems.hasNext()){
				System.out.println(studentItems.next());
			}
			System.out.println("---------------------------------");
			//第二次查询
			Iterator<Student> studentItems2 = session.createQuery(hql).iterate();
			while(studentItems2.hasNext()){
				System.out.println(studentItems2.next());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*N+1问题的解决方案*/
	@Test
	public void test10_HQL_iterateAndList(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//第一次查询:使用List()
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			System.out.println("---------------------------------");
			//第二次查询:使用iterate()
			Iterator<Student> studentItems2 = session.createQuery(hql).iterate();
			while(studentItems2.hasNext()){
				System.out.println(studentItems2.next());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*命名查询，HQL查询*/
	@Test
	public void test11_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//查询语句从所有映射文件中读取
			Student student = (Student)session.getNamedQuery("queryById")
					                          .setInteger("myid", 2)
					                          .uniqueResult();
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































