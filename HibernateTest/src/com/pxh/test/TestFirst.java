package com.pxh.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.pxh.model.User;

public class TestFirst {

	@Test
	public void test01(){
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
									.applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		session.beginTransaction();
		User u = new User();
		u.setId(2);
		u.setUsername("panxinhui");
		u.setPassword("123456");
		u.setDicname("潘新辉");
		session.save(u);
		session.getTransaction().commit();
	}
}
