package com.many_to_many_map;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int eid;
	private String name;
	
	@ManyToMany
	private List<Project> projects;
	
	//Default Constructor
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	//Getter Setter
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
