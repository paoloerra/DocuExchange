package model;
import interfaces.UserInterface;  

public class Studente implements UserInterface {

	  /**
	   * Variables.
	   */
	  private String email;
	  private String name;
	  private String surname;
	  private String password;
	  private char sex;
	  private int userType;
	  private int limitDownload;


	  /**
	   * Contructor.
	   * 
	   * @param email is the address that the Student uses to Log in the site.
	   * @param name is the name of the Student.
	   * @param surname is the surname of the Student.
	   * @param sex specifies the sex of the Student with one letter (M,F).
	   * @param password is the password that the Student uses to Log in the site.
	   * @param userType specifies the type of the user (0,1,2).
	   */
	  public Studente(String email, String name, String surname, char sex, String password, int userType, int limitDownload) {
	    this.email = email;
	    this.name = name;
	    this.surname = surname;
	    this.password = password;
	    this.sex = sex;
	    this.userType = userType;
	    this.limitDownload = limitDownload;

	  }

	  /**
	   * Empty Constructor.
	   */
	  public Studente() {}

	  /**
	   * Get the email address of the Student.
	   */
	  public String getEmail() {
	    return email;
	  }

	  /**
	   * Get the name of the Student.
	   */
	  public String getName() {
	    return name;
	  }

	  /**
	   * Get the surname of the Student.
	   */
	  public String getSurname() {
	    return surname;
	  }

	  /**
	   * Get the sex of the Student (M,F).
	   */
	  public char getSex() {
	    return sex;
	  }

	  /**
	   * Get the password of the Student.
	   */
	  public String getPassword() {
	    return password;
	  }
	  
	  public int getLimitDownload() {
		  return limitDownload;
	  }
	  /**
	   * Set the email of the Admin.
	   * 
	   * @param email is the address that the Admin uses to Log in the site.
	   */
	  public void setEmail(String email) {
	    this.email = email;
	  }

	  /**
	   * Set the name of the Student.
	   * 
	   * @param name is the name of the Student.
	   */
	  public void setName(String name) {
	    this.name = name;
	  }

	  /**
	   * Set the surname of the Student.
	   * 
	   * @param surname is the surname of the Student.
	   */
	  public void setSurname(String surname) {
	    this.surname = surname;
	  }

	  /**
	   * Set the sex of the Student.
	   * 
	   * @param sex specifies the sex of the Student with one letter (M,F).
	   */
	  public void setSex(char sex) {
	    this.sex = sex;
	  }

	  /**
	   * Set the password of the Student.
	   * 
	   * @param password is the password that the Student uses to Log in the site.
	   */
	  public void setPassword(String password) {
	    this.password = password;
	  }

	  /**
	   * Specifies if the user is allowed to see the page.
	   */
	  
	  public int getUserType() {
		  return this.userType;
	  }
	  
	  public void setUserType(int UserType) {
		  this.userType = UserType;
	  }
	  
	  public void setLimitDownload(int limit) {
		  this.limitDownload = limit;
	  }
	  //NON HO CAPITO penso nella fase di testing si faccia
	/*  @Override
	  public boolean validate() {
	    return new Stub().database.containsKey(getEmail())
	        && new Stub().database.containsValue(getPassword());
	  }
	*/
	
}
