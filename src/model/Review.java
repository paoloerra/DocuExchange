package model;

public class Review {

	private int idReview;
	private String studentEmail;
	private int idNote;
	private String comment;
	private int star;
	
	
	public int getIdReview() {
		return idReview;
	}


	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}


	public String getStudentEmail() {
		return studentEmail;
	}


	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}


	public int getIdNote() {
		return idNote;
	}


	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getStar() {
		return star;
	}


	public void setStar(int star) {
		this.star = star;
	}


	public Review(int idReview,String studentEmail,int idNote,String comment,int star) {
		
		this.idReview=idReview;
		this.idNote=idNote;
		this.comment=comment;
		this.studentEmail=studentEmail;
		this.star=star;
	}
}
