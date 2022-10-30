package com.anmol.HibernateInheritance;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SaveDataClientTest {

	public static void main(String[] args) throws ParseException {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		
	    try(Session session = factory.openSession()) {
	    	Person person = new Person();
			person.setName("Sudha Verma");
			person.setGender("Female");
			
			Employee employee = new Employee();
			employee.setBonus(new BigDecimal("277.389"));
			employee.setDeptName("IT");
			employee.setDoj(new Date());
			employee.setEmail("dipesh.cs@gmail.com");
			employee.setName("Dipesh");
			employee.setSalary(80000.2872);
			employee.setGender("Male");
			
			Student student = new Student();
			student.setName("Shuruti");
			student.setGender("Female");
			student.setFee(20000.00f);
			student.setSchoolName("DPS");
			student.setSectionName("12th Std");
			
			session.beginTransaction();
			session.save(person);
			session.save(student);
			session.save(employee);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}