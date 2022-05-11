package com.itcademy.hibernate.db;

public class Main {

	public static void main(String[] args) {
		GeneralDB db = new GeneralDB();
		
		db.createSF();
		
		db.createUser();
		
		db.cancelSF();

	}

}
