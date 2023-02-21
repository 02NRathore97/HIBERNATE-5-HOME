package com.rays;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity(name="student_details")   //to change table name

//@Entity
//@Table(name="mystudents")         //to change table name

@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	private int id;
	private String name;
	private String city;
	
	
	//source->Generate Constructor using field
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	//source->Generate Constructor from superclass
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//source->Generate Getter/Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" : "+this.name+" : "+this.city;
	}
}
