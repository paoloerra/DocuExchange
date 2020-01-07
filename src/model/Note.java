package model;

public class Note {
	/**
	 * variables
	 */
	private int idNote;
	private String studentEmail;
	private String autor;
	private String course;
	private String professor;
	private String description;
	private String fileName;
	private int checked;
	/**
	 * 
	 * @param idNote is the id of note
	 * @param studentEmail is the email of student
	 * @param course is the name of course
	 * @param professor the name of the professor who teaches the course
	 * @param description is the description of course
	 * @param fileName is the name of the file
	 */
	
	public Note(int idNote,String studentEmail,String course,String professor,String description,String fileName, String autor, int checked) {
		this.idNote=idNote;
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
	public Note() {}
	/**
	 * 
	 * @return id of note
	 */
	public int getIdNote() {
		return idNote;
	}

	/**
	 * set the id of note
	 * @param idNote is the id of note
	 */
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}
	
	public int getChecked() {
		return checked;
	}
	
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	/**
	 *  
	 * @return  the email of the student who wrote the note
	 */
	public String getStudentEmail() {
		return studentEmail;
	}
	
	/**
	 * set the email of the student who wrote the note 
	 * @param studentEmail
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * 
	 * @return the name of the course of the note
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * set the name of the course of the note
	 * @param course the name of the course of the note
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 
	 * @return the name of professor of the course
	 */
	public String getProfessor() {
		return professor;
	}

	/**
	 * set the name of professor of the course
	 * @param professor the name of professor of the course
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	/**
	 * 
	 * @return description of the note
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * set description of the note
	 * @param description the description of the note
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return filename of the note
	 */
	public String getFileNamePDF() {
		return fileName;
	}

	/**
	 * set filename of the note
	 * @param fileName of the note
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
