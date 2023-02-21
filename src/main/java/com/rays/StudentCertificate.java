
package com.rays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_certificate")
public class StudentCertificate {
	@Id
	private int id;
	private String name;
	private String city;
	
	private Certificate certificate;
	/*
	 * Default Constructor
	 */
	public StudentCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * Parameterize Constructor
	 */
	public StudentCertificate(int id, String name, String city, Certificate certificate) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certificate = certificate;
	}

	/*
	 * Getter Setter
	 */
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

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	
	
}
