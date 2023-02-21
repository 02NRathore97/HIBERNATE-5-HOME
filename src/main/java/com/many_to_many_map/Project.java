package com.many_to_many_map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	@Column(name="project_name")
	private String projectname;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> emps;
	
	
	//Default Constructor
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	//Getter Setter
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
