package com.anmol.OneToOneMapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Address add = new Address();
		add.setPath("Ballarpur");
		
		Employee emp = new Employee();
		emp.setName("ANmol");
		emp.setSalary(1000000);
		emp.setAddress(add);
		add.setEmp(emp);
		
		session.save(emp);
		
		tx.commit();
		
		Employee e = session.get(Employee.class, 0);
		System.out.println(e);
		
		Address a = session.get(Address.class, 0);
		System.out.println(a);
		
		/*
		 * Transaction tx1 = session.beginTransaction(); session.delete(a);
		 * tx1.commit();
		 */
		
		
		session.clear();
		
	}

}
