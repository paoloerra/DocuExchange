package interfaces;

import java.util.ArrayList;

public interface UserInterfaceDAO {

	public boolean saveStudent(UserInterface user);
	public ArrayList<UserInterface> selectStudent(String EmailStudentSession);
	public UserInterface SelectLoginUser(String email, String password);
	public ArrayList<UserInterface> selectSearchForNameAndSurnameStudent(String name, String surname, String studentSession);
	public ArrayList<UserInterface> selectSearchForNameStudent(String name, String studentSession);
	public boolean UpdateProfileUser(UserInterface user);
	public boolean UpdateResetLimitDownloadStudent(String email);

}
