package com.itcademy.hibernate.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class DBGeneric {
	
	public static SessionFactory createSF() {
		final StandardServiceRegistry register = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf;
		try {
			sf = new MetadataSources(register).buildMetadata().buildSessionFactory();
			System.out.println("SF erstellet");
			return sf;
		} catch (Exception e) {
			 	System.out.println("SF konnte nicht erstellt werden.");
		}
		return null;
	}
}
