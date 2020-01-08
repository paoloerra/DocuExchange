package model;

import interfaces.NoteInterface;

public class Request implements NoteInterface {
	/**
	 * variables
	 */
	private int id;
	private String studentEmail;
	private String autor;
	private String course;
	private String professor;
	private String description;
	private String fileName;
	
	private int checked; //0
	/**
	 * 
	 * @param idNote is the id of note
	 * @param studentEmail is the email of student
	 * @param course is the name of course
	 * @param professor the name of the professor who teaches the course
	 * @param description is the description of course
	 * @param fileName is the name of the file
	 */
	
	public Request(int id,String studentEmail,String course,String professor,String description,String fileName, String autor, int checked) {
		this.id=id;
		this.studentEmail=studentEmail;
		this.course=course;
		this.professor=professor;
		this.description=description;
		this.fileName=fileName;
		this.checked = checked;
		this.autor = autor;
	}
	/**
	 * empty constructor
	 */
	public Request() {}
	
	public int getId() {
		return this.id;
	}
	public String getStudentEmail() {
		return this.studentEmail;
	}
	public String getCourse() {
		return this.course;
	}
	public String getProfessor() {
		return this.professor;
	}
	public String getDescription() {
		return this.description;
	}
	public String getFileName() {
		return this.fileName;
	}
	public String getAutor() {
		return this.autor;
	}
	public int getChecked() {
		return this.checked;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setStudentEmail(String email) {
		this.studentEmail = email;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}


}
