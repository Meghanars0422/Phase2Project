package com.ecommerce;

public class Student {
	private long StudentID;
	private String name;
	private long age;
	private String address;
	private String gender;
	private ClassTable classes;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getStudentID() {
		return StudentID;
	}

	public void setStudentID(long studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ClassTable getClasses() {
		return classes;
	}

	public void setClasses(ClassTable classes) {
		this.classes = classes;
	}

	
	
}
