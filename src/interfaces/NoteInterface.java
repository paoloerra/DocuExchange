package interfaces;

public interface NoteInterface {
  // get
	public int getId();
	public String getStudentEmail();
	public String getCourse();
	public String getProfessor();
	public String getDescription();
	public String getFileName();
	public String getAutor();
	public int getChecked();
	
  // set
	public void setID(int id);
	public void setStudentEmail(String email);
	public void setCourse(String course);
	public void setProfessor(String professor);
	public void setDescription(String description);
	public void setFileName(String fileName);
	public void setAutor(String autor);
	public void setChecked(int checked);
}
