package com.itcademy.hibernate.oneToMany;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.itcademy.hibernate.db.DBGeneric;
import com.itcademy.hibernateCon.entity.Gamer;
import com.itcademy.hibernateCon.entity.emailAddress;

public class MainGeneric {

	public static void main(String[] args) {
		SessionFactory factory = DBGeneric.createSF();
		Session ses = factory.openSession();
		
		ses.beginTransaction();
		
		
		// TODO:
		
		/*emailAddress a1 = new emailAddress("halo@web.de");
		emailAddress a2 = new emailAddress("ciao@web.de");

		Gamer gamer = new Gamer("Hannah", 24);
		
		Set<emailAddress> emails = new HashSet<emailAddress>();
		emails.add(a1);
		emails.add(a2);
		
		gamer.setAddresses(emails);
		
		ses.save(gamer);*/
		
		Gamer gamer = ses.get(Gamer.class, 2);
		
		ses.delete(gamer);
		
		
		ses.getTransaction().commit();
		ses.close();
		factory.close();
	}
}
