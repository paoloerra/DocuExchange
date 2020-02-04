package model.bean;

import java.io.FileInputStream;

import model.interfaces.NoteInterface;

public class Note implements NoteInterface {
	/**
	 * variables
	 */
	private int id;
	private String studentEmail;
	private String autor;
	private String course;
	private String professor;
	private String description;
	private FileInputStream file;
	
	private int checked; //1
	/**
	 * 
	 * @param id is the id of note
	 * @param studentEmail is the email of the autor of the note
	 * @param course is the name of course
	 * @param professor the name of the professor who teaches the course
	 * @param description is the description of note
	 * @param fileName is the name of the file
	 * @param checked it's 0 if it's a request, 1 if it's a published note.
	 */
	
	public Note(int id,String studentEmail,String course,String professor,String description, FileInputStream file, String autor, int checked) {
		this.id=id;
		this.studentEmail=studentEmail;
		this.course=course;
		this.professor=professor;
		this.description=description;
		this.file = file;
		this.checked = checked;
		this.autor = autor;
	}
	
	/**
	 * Empty constructor.
	 */
	public Note() {}
	
	/**
	 * Get the id of the note.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Get the email of student.
	 */
	public String getStudentEmail() {
		return this.studentEmail;
	}
	
	/**
	 * Get the name of course.
	 */
	public String getCourse() {
		return this.course;
	}
	
	/**
	 * Get the name of professor.
	 */
	public String getProfessor() {
		return this.professor;
	}
	
	/**
	 * Get the description of the note.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Get the name of file.
	 */
	public FileInputStream getFile() {
		return this.file;
	}
	
	/**
	 * Get the name and surname of the autor of the note.
	 */
	public String getAutor() {
		return this.autor;
	}
	
	/**
	 * Get the vaule Checked.
	 * 
	 * @param checked it's 0 if it's a request, 1 if it's a published note.
	 */
	public int getChecked() {
		return this.checked;
	}
	
	/**
	 * Set id of the note.
	 * 
	 * @param id is the id of the note.
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Set the email of autor of the note.
	 * 
	 * @param email is the email of the student.
	 */
	public void setStudentEmail(String email) {
		this.studentEmail = email;
	}
	
	/**
	 * Set course of the note.
	 * 
	 * @param course is the course of the note
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	
	/**
	 * Set professor of course.
	 * 
	 * @param set the name of the course teacher.
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	/**
	 * Set the description of the note.
	 * 
	 * @param description is the description of the note.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Set the name of file.
	 * 
	 * @param fileName is the name of file of note.
	 */
	public void setFile(FileInputStream file) {
		this.file = file;
	}
	
	/**
	 * Set autor of note.
	 * 
	 * @param autor is the name and surname of autor of note.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Set the value checked of note
	 * 
	 * @param checked it's 0 if it's a request, 1 if it's a published note.
	 */
	public void setChecked(int checked) {
		this.checked = checked;
	}
}
