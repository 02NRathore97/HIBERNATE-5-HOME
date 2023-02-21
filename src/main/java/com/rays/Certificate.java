package com.rays;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String course;
	private String duration;
	
	/*
	 * Default Constructor
	 */
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * Parameterized Constructor
	 */
	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	
	/*
	 * Getter  setter
	 */
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	}
