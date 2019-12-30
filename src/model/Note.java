package model;

public class Note {
	/**
	 * variables
	 */
	private int idNote;
	private String studentEmail;
	private String corso;
	private String professore;
	private String descrizione;
	private String fileName;
	/**
	 * 
	 * @param idNote is the id of note
	 * @param studentEmail is the email of student
	 * @param corso is the name of course
	 * @param professore the name of the professor who teaches the course
	 * @param descrizione is the description of course
	 * @param fileName is the name of the file
	 */
	
	public Note(int idNote,String studentEmail,String corso,String professore,String descrizione,String fileName) {
		this.idNote=idNote;
		this.studentEmail=studentEmail;
		this.corso=corso;
		this.professore=professore;
		this.descrizione=descrizione;
		this.fileName=fileName;
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
	public String getCorso() {
		return corso;
	}

	/**
	 * set the name of the course of the note
	 * @param corso the name of the course of the note
	 */
	public void setCorso(String corso) {
		this.corso = corso;
	}

	/**
	 * 
	 * @return the name of professor of the course
	 */
	public String getProfessore() {
		return professore;
	}

	/**
	 * set the name of professor of the course
	 * @param professore the name of professor of the course
	 */
	public void setProfessore(String professore) {
		this.professore = professore;
	}

	/**
	 * 
	 * @return description of the note
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * set description of the note
	 * @param descrizione the description of the note
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
