package com.itcademy.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.itcademy.hibernateCon.entity.Passport;
import com.itcademy.hibernateCon.entity.Teacher;
import com.itcademy.hibernateCon.entity.TeacherAddresse;
import com.itcademy.hibernateCon.entity.User;

public class OneToOneBiDB {

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
		
	public void createTeacher() {
				
		Teacher teacher = new Teacher("Werner", "Sport");
		TeacherAddresse addresse = new TeacherAddresse("München", "Hauptstraße");
		
		Session ses = sf.openSession();
		
		ses.beginTransaction();
		
		teacher.setTeacherAddresse(addresse);
		addresse.setTeacher(teacher);
		
		ses.save(teacher);
		
		
		
		ses.getTransaction().commit();
		ses.close();
	}
	


	
	
}
