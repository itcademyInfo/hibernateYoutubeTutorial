package com.itcademy.hibernate.relationships;

public class OneToOneUniDirectional {

	/**
	 *  One To One - Unidirectional
	 * 
	 *  User: id (PK), first name, last name, age, Passport (FK)
	 *  Jeder User hat ein Passport
	 *  
	 *  Passport(FK) --> Passport: PID (PK), passport No
	 *  
	 *  Fremdschl�ssel in User ist Prim�rschl�ssel in Passport
	 *  Beziehung nur in eine Richtung hier User -> Passport
	 *  
	 * 
	 */
}
