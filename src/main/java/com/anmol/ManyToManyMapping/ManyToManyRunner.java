package com.anmol.ManyToManyMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyRunner {

	public static void main(String[] args) {
		Tag t1 = new Tag();
		t1.setName("java");
		
		Tag t2 = new Tag();
		t2.setName("cpp");
		
		Tag t3 = new Tag();
		t3.setName("python");
		
		Post p1 = new Post();
		p1.setTitle("first");
		p1.setTags(List.of(t1,t2,t3));
		
		Post p2 = new Post();
		p2.setTitle("Second");
		p2.setTags(List.of(t1,t3));
		
		t1.setPosts(List.of(p2,p1));
		t2.setPosts(List.of(p1));
		t3.setPosts(List.of(p2,p1));
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		s.save(p1);
		s.save(p2);
		
		s.save(t1);
		s.save(t2);
		s.save(t3);
		
		System.out.println(p1.getTags().size());
		System.out.println(p2.getTags().size());
		
		System.out.println(t1.getPosts().size());
		
		tx.commit();
	}

}
