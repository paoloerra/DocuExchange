package model.interfaces;

public interface ReviewInterface {
  // get
	public int getIdReview();
	public String getStudentEmail();
	public int getIdNote();
	public String getComment();
	public int getStar();
	public String getAutor();
	
  // set
	public void setIdReview(int idReview);
	public void setStudentEmail(String email);
	public void setIdNote(int idNote);
	public void setComment(String comment);
	public void setAutor(String autor);
	public void setStar(int star);
}
