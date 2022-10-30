package com.anmol.OneToManyMapping;


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
		
		Comment c1 = new Comment();
		c1.setContent("abcwijcbs");
		
		Comment c2 = new Comment();
		c2.setContent("elkfnrji");
		
		Post p = new Post();
		p.setTitle("First");
		p.setComments(List.of(c1,c2));
		
		c1.setPost(p);
		c2.setPost(p);
		
		session.save(p);
		
		tx.commit();		
		
		session.clear();
		
	}

}
