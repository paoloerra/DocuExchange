package interfacce;

public interface UserInterface {
  // get
  public String getEmail();

  public String getName();

  public String getSurname();

  public char getSex();

  public String getPassword();
//sempre in odd non c '�
  public int getUserType();

  // set
  public void setEmail(String e);

  public void setName(String n);

  public void setSurname(String s);

  public void setSex(char s);

  public void setPassword(String p);
//idem
  public void setUserType(int u);
//anche quwesto
//  public boolean validate();


}
