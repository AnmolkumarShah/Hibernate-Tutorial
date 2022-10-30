package com.anmol.OneToManyMapping2;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Address add1 = new Address();
		add1.setPath("Ballarpur");
		
		Address add2 = new Address();
		add2.setPath("Nagpur");
		
		Address add3 = new Address();
		add3.setPath("Chandrapur");
		
		
		Employee emp = new Employee();
		emp.setName("Anmol");
		emp.setSalary(1000000);
		emp.setAddress(List.of(add1,add2,add3) );
		
		add1.setEmp(emp);
		add2.setEmp(emp);
		add3.setEmp(emp);
		
		session.save(emp);
		
		tx.commit();		
		
		session.clear();
		
	}

}
