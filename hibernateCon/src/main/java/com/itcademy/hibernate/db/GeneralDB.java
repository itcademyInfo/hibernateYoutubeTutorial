package com.itcademy.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.itcademy.hibernateCon.entity.User;

public class GeneralDB {

	protected SessionFactory sf;
	
	public void createSF() {
		final StandardServiceRegistry register = new StandardServiceRegistryBuilder().configure().build();
		
		try {
			sf = new MetadataSources(register).buildMetadata().buildSessionFactory();
			System.out.println("SF erstellet");
		} catch (Exception e) {
			 	System.out.println("SF konnte nicht erstellt werden.");
		}
	}
	
	public void cancelSF() {
		System.out.println("sF wurde geschlossen.");
		
		sf.close();
	}
	
	// CRUD Operationen 1. Create
	
	public void createUser() {
		User user = new User("Hans", "Peter", 15);
		
		Session ses = sf.openSession();
		
		ses.beginTransaction();
		
		ses.save(user);
		
		ses.getTransaction().commit();
		System.out.println("User hinzugefügt");
		ses.close();
	}
}
