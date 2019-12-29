package model;

public class Note {
	private int idNote;
	private String studentEmail;
	private String corso;
	private String professore;
	private String descrizione;
	private String fileName;
	
	
	public Note(int idNote,String studentEmail,String corso,String professore,String descrizione,String fileName) {
		this.idNote=idNote;
		this.studentEmail=studentEmail;
		this.corso=corso;
		this.professore=professore;
		this.descrizione=descrizione;
		this.fileName=fileName;
	}

	public Note() {}
	
	public int getIdNote() {
		return idNote;
	}


	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}


	public String getStudentEmail() {
		return studentEmail;
	}


	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}


	public String getCorso() {
		return corso;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public String getProfessore() {
		return professore;
	}


	public void setProfessore(String professore) {
		this.professore = professore;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getFileNamePDF() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
