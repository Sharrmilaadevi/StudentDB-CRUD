package com.mydemo.crudapp.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_percentage")
	private float percentage;
	
	@Column(name="student_branch")
	private String branch;
	
	
	
	public Student() {
		
	}
	public Student(int rollno, String name, float percentage, String branch) {
	
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ "]";
	}
	
	
	
}
