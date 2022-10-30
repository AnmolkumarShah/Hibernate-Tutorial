package com.anmol.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session s = factory.openSession();

		Student stu = new Student();
		stu.setName("Anmol");
		stu.setCity("Nagpur");

		Transaction tx = s.beginTransaction();
		s.save(stu);
		tx.commit();

		s.close();

		System.out.println(factory);

	}
}
