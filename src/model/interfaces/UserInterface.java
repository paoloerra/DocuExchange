package model.interfaces;

public interface UserInterface {
  // get
  public String getEmail();
  public String getName();
  public String getSurname();
  public char getSex();
  public String getPassword();
  public int getUserType();
  public int getLimitDownload();

  // set
  public void setEmail(String e);
  public void setName(String n);
  public void setSurname(String s);
  public void setSex(char s);
  public void setPassword(String p);
  public void setUserType(int u);
  public void setLimitDownload(int l);
}
