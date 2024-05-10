package com.sms.bean;






import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")  
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	@Column(name="name")
	private String name; 
	@Column(name="age") 
	private int age; 
	
	@ManyToOne
	private Department department;

	
	
	public Student() {
		super();
	}

	public Student(String name, int age, Department department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
