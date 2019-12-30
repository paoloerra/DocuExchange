package model;

public class Review {
	/**
	 * variables
	 */
	private int idReview;
	private String studentEmail;
	private int idNote;
	private String comment;
	private int star;
	
	
	/**
	 * constructor
	 * @param idReview id of review
	 * @param studentEmail email of student
	 * @param idNote id of the note
	 * @param comment comment of the note
	 * @param star number of star
	 */
	
	public Review(int idReview,String studentEmail,int idNote,String comment,int star) {
		
		this.idReview=idReview;
		this.idNote=idNote;
		this.comment=comment;
		this.studentEmail=studentEmail;
		this.star=star;
	}
	/**
	 * 
	 * @return id of review
	 */
	public int getIdReview() {
		return idReview;
	}

	/**
	 * set the id of review 
	 * @param idReview 
	 */
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	/**
	 * get email of student
	 * @return email of student
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/**
	 * set email of student
	 * @param studentEmail email of student
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * get idnote of the review

	 */
	public int getIdNote() {
		return idNote;
	}

	/**
	 * set idnote of review
	 * @param idNote
	 */
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	/**
	 * get comment of review 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * set comment of review
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * get the number of star 
	 */
	public int getStar() {
		return star;
	}

	/**
	 * set the number of star 
	 * @param star
	 */
	public void setStar(int star) {
		this.star = star;
	}


	
}
