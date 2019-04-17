package com.hxb.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.junit.Test;
import com.hxb.beans.Country;
import com.hxb.beans.Minister;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*��������׼��*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			Minister minister3 = new Minister("ccc");
			Minister minister4 = new Minister("ddd");
			Minister minister5 = new Minister("eee");
			
			Country country = new Country("USA");
			Country country2 = new Country("CHN");
			
			country.getMinisters().add(minister);
			country.getMinisters().add(minister2);
			country.getMinisters().add(minister3);
			country2.getMinisters().add(minister4);
			country2.getMinisters().add(minister5);
			
			session.save(country);
			session.save(country2);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	/*֤��Query��ѯ���ͬ����ŵ�һ����������*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ��ʹ��Query��ѯ
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = session.get(Country.class, 2);
			System.out.println("country:" + country2);
			
			session.clear();
			
			Country country3 = session.get(Country.class, 2);
			System.out.println("country:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*Query���治��ӻ����ж�ȡ����*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ��ʹ��Query��ѯ
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			Country country3 = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*����Query�ܿ��ص�Query���棬�ͻ�ӻ����ж�ȡ����*/
	@Test
	public void test04(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//.setCacheable(true)����Query����
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			Country country3 = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*Query��������*/
	@Test
	public void test05(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country:" + country);
			
			String hql2 = "from Country where cid in (2)";
			Country country2 = (Country)session.createQuery(hql2).setCacheable(true).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			String hql3 = "from Country where cid like '2'";
			Country country3 = (Country)session.createQuery(hql3).setCacheable(true).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�޸�ʱ���*/
	@Test
	public void test06(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ����϶������һ����������
			Country country = session.get(Country.class, 2);
			System.out.println("����ǰcountry.name:" + country.getCname());
			
			/*�˸����ƹ���һ�����棬ֱ�ӸĶ���DB�����޸������û���κι�ϵ*/
			String hql = "update Country set cname='AAA' where cid=2";
			session.createQuery(hql).executeUpdate();
			
			Country country2 = session.get(Country.class, 2);
			System.out.println("���º�country2.name:" + country2.getCname());
			
			session.clear();
			
			//��֮ǰ��ѧϰ���ۣ������get()�����Ȳ���һ�����棬�ٲ��Ҷ�������
			//û�дӶ��������ȡ������ݣ����Ǵ�DB�н����˲�ѯ
			//��Ϊquery��executeUpdate���޸Ķ�����������е�һ�����ԣ�updateTimestamp,�޸�ʱ���
			//ʵ���϶��������϶�����������л�������ݣ�Ҫ��һ��������󻺴����ݶ�һ�����ԣ��޸�ʱ���
			//һ��������Ա��޸ģ���ô����ѯ�᲻�Ӷ��������ж�ȡ���ݣ�����ֱ�Ӵ�DB�в�ѯ
			Country country3 = session.get(Country.class, 2);
			System.out.println("���������country3.name:" + country3.getCname());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}

































