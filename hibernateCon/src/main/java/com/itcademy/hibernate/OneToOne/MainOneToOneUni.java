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

public class MainOneToOneUni {

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
	
	// CRUD Operationen 1. Create 2. read 3. update 4. delete
	
	public void createUser() {
		
		/* Directional 1 - 1
		Passport passport = new Passport(passportno);
		User user = new User(firstName, lastName, matrNr, passport);
		*/
		
		Teacher teacher = new Teacher("Otto", "Informatik");
		TeacherAddresse addresse = new TeacherAddresse("Stuttfart", "Hauptstraße");
		
		System.out.println("Test");
		
		Session ses = sf.openSession();
		
		ses.beginTransaction();
		
		teacher.setTeacherAddresse(addresse);
		addresse.setTeacher(teacher);
		ses.save(teacher);
		
		//user.setPassport(passport);
		//ses.save(user);
		
		ses.getTransaction().commit();
		//System.out.println("User hinzugefügt");
		ses.close();
	}
	
	// read user data
	public User readUserData(int id) {
		Session ses = sf.openSession();
		
		User userDB = ses.get(User.class, id);
		
		System.out.println("Unser User hat den Namen: " + userDB.getFirstName() + " und das Alter: " + userDB.getAge());
		
		ses.close();
		
		return userDB;
	}
	
	// update user data
	public void updateUserData(String firstName, int id) {
		Session ses = sf.openSession();
		
		User userDB = ses.get(User.class, id);
		userDB.setFirstName(firstName);
		
		ses.beginTransaction();
		
		ses.update(userDB);
		
		ses.getTransaction().commit();
		ses.close();
	}
	
	// delete user 
	public void deleteUser(int id) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		
		User userDB = ses.get(User.class, id);
		
		ses.delete(userDB);
		
		ses.getTransaction().commit();
		ses.close();
		
	}

	
	
}
