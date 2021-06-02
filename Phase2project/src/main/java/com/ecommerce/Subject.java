package com.ecommerce;

public class Subject {

	private long SubjectID;
	private String subjectname;
	private ClassTable classes;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(long subjectID) {
		SubjectID = subjectID;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public ClassTable getClasses() {
		return classes;
	}
	public void setClasses(ClassTable classes) {
		this.classes = classes;
	}
	
	
}
