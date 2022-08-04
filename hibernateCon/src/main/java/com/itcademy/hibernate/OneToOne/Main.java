package com.itcademy.hibernate.OneToOne;

public class Main {

	public static void main(String[] args) {
		
		OneToOneBiDB db = new OneToOneBiDB();
		db.createSF();
		
		db.createTeacher();
		
		db.cancelSF();

	}

}
