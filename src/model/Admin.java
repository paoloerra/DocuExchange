package model;

import interfacce.UserInterface;  

public class Admin implements UserInterface {

  /**
   * Variables.
   */
  private String email;
  private String name;
  private String surname;
  private String password;
  private char sex;

  private int userType;//noi non ce l 'abbiamo nell odd

  /**
   * Contructor.
   * 
   * @param email is the address that the Admin uses to Log in the site.
   * @param name is the name of the Admin.
   * @param surname is the surname of the Admin.
   * @param sex specifies the sex of the Admin with one letter (M,F).
   * @param password is the password that the Admin uses to Log in the site.
   * @param userType specifies the type of the user (0,1,2).
   */
  public Admin(String email, String name, String surname, char sex, String password, int userType) {
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.sex = sex;
    this.userType = userType;
  }

  /**
   * Empty Constructor.
   */
  public Admin() {}

  /**
   * Get the email address of the Admin.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the name of the Admin.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the surname of the Admin.
   */
  public String getSurname() {
    return surname;
  }

  /**
   * Get the sex of the Admin (M,F).
   */
  public char getSex() {
    return sex;
  }

  /**
   * Get the password of the Admin.
   */
  public String getPassword() {
    return password;
  }
//in odd non c�
  /**
   * Get the type of the User (0,1,2).
   */
  public int getUserType() {
    return userType;
  }
  
  public int getLimitDownload() {
	  return 0;
  }

  /**
   * Set the email of the Admin.
   * 
   * @param email is the address that the Admin uses to Log in the site.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public void setLimitDownload() {
  }
  /**
   * Set the name of the Admin.
   * 
   * @param name is the name of the Admin.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set the surname of the Admin.
   * 
   * @param surname is the surname of the Admin.
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Set the sex of the Admin.
   * 
   * @param sex specifies the sex of the Admin with one letter (M,F).
   */
  public void setSex(char sex) {
    this.sex = sex;
  }

  /**
   * Set the password of the Admin.
   * 
   * @param password is the password that the Admin uses to Log in the site.
   */
  public void setPassword(String password) {
    this.password = password;
  }
  //non c� in odd
  /**
   * Set the type of the user.
   * 
   * @param userType specifies the type of the user (0,1,2).
   */
  public void setUserType(int userType) {
    this.userType = userType;
  }

public void setLimitDownload(int l) {
	// TODO Auto-generated method stub
	
}

  /**
   * Specifies if the user is allowed to see the page.
   */
  //NON HO CAPITO penso nella fase di testing si faccia
/*  @Override
  public boolean validate() {
    return new Stub().database.containsKey(getEmail())
        && new Stub().database.containsValue(getPassword());
  }
*/
}

