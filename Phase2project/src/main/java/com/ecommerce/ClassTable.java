package com.ecommerce;

public class ClassTable {
	private long ClassID;
	private String Classname;
	private Teacher teachers;
	
	public ClassTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getClassID() {
		return ClassID;
	}
	public void setClassID(long classID) {
		ClassID = classID;
	}
	public String getClassname() {
		return Classname;
	}
	public void setClassname(String classname) {
		Classname = classname;
	}
	public Teacher getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}
	
	
}
