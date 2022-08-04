package com.itcademy.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainGeneric {

	public static void main(String[] args) {
		SessionFactory factory = DBGeneric.createSF();
		Session ses = factory.openSession();
		
		ses.beginTransaction();
		
		// TODO:
		
		ses.getTransaction().commit();
		ses.close();
		factory.close();
	}
}
