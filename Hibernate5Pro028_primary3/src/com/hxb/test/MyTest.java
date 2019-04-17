package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

/*测试CURD*/
@SuppressWarnings("all")
public class MyTest {
	
	/*增加学生对象*/
	@Test
	public void testInsert(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("张三", 23, 93.5);
			//增加对象
			session.save(student);
			//增加对象的第二种方式，这是JPA里面的API而不是Hibernate的API,一般不使用这个方法
			//session.persist(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*删除学生对象*/
	@Test
	public void testDelete(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("张三", 23, 93.5);
			//不能直接删除对象,而是通过主键删除，也就是对象要具有唯一性
			student.setId(1);
			session.delete(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*修改学生对象*/
	@Test
	public void testUpdate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("李四", 45, 95.5);
			//修改对象
			student.setId(2);
			session.update(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*修改学生对象*/
	@Test
	public void testQuery(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			System.out.println(student);
			/*get()与load()共同点：根据ID加载对象，区别是get()查询不到对象时，会返回null；而load()查询不到对象时，会报异常*/
			Student student2 = session.load(Student.class, 2);
			System.out.println(student2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*测试.saveOrUpdate()*/
	@Test
	public void testSaveOrUpdate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("李四", 45, 95.5);
			//如果操作的对象有ID,则执行.update()，否则执行.save();如果被操作的对象中数据库中没有此ID，则会抛出异常
			session.saveOrUpdate(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//测试.getCurrentSession()对事务的要求
	@Test
	public void testGetLoad(){
		Session session = HbnUitls.getSession();
		//通过.getCurrentSession()获取到的Session所有执行的查询，必须在事务环境下操作
		Student student = session.get(Student.class, 2);
		System.out.println(student);
	}
	
	//测试.openSession()对事务的要求
	@Test
	public void testGetLoad2(){
		Session session = HbnUitls.getSessionFactory().openSession();
		//通过.openSession()获取到的Session所有执行的操作，无需一定要在事务环境下执行
		Student student = session.get(Student.class, 2);
		System.out.println(student);
	}
	
	@Test
	public void testCURD(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			/*增删改操作若放在同一事务下运行，则系统默认的执行顺序为增改删*/
			//删除
			Student student = session.get(Student.class, 2);
			session.delete(student);
			//通过刷新Session缓存，可以打乱同一事务下默认的执行顺序
//			session.flush();
			
			//插入
			Student student2 = new Student("王五", 23, 54.2);
			session.save(student2);
			
			//修改
			Student student3 = session.get(Student.class, 3);
			student3.setName("赵六");
			session.update(student3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
		}
	}
}








































