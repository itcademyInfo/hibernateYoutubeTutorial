package com.itcademy.hibernateCon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "teacheraddress")
public class TeacherAddresse {

	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name="property", value = "teacher"))
	@Column(name = "TID")
	private int id;
	
	@Column(name = "city")
	private String stadt;
	
	@Column(name = "stra�e")
	private String stra�e;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Teacher teacher;

	public TeacherAddresse() {
		
	}

	public TeacherAddresse(String stadt, String stra�e) {
		super();
		this.stadt = stadt;
		this.stra�e = stra�e;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStra�e() {
		return stra�e;
	}

	public void setStra�e(String stra�e) {
		this.stra�e = stra�e;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
