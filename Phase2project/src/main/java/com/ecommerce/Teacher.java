package com.ecommerce;

public class Teacher {
	private long TeacherID;
	private String Teachername;
	private Subject subjects;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(long teacherID) {
		TeacherID = teacherID;
	}
	public String getTeachername() {
		return Teachername;
	}
	public void setTeachername(String teachername) {
		Teachername = teachername;
	}
	public Subject getSubjects() {
		return subjects;
	}
	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
	}
	
	
}
