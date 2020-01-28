package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.DAO.UserDAO;
import controller.StudentInsertReview;
import model.Student;
import model.interfaces.UserInterface;

public class UserDAOTest {
	  
	//eliminare 
	
	  @Test
	  public void saveStudentTest() {

		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa3@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertTrue(d.saveStudent(newStudent));
	  }
	  @Test
	  public void selectStudentTest() {

		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  ArrayList<UserInterface> arr=new ArrayList<UserInterface>();
		  arr.add(newStudent);
		  assertEquals(arr,d.selectStudent("m.derosa102@studenti.unisa.it"));
	  }
	  @Test
	  public void loginStudentTest() {
		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertEquals(newStudent,d.SelectLoginUser("m.derosa102@studenti.unisa.it", "Abracadabra"));
	  }
	  @Test
	  public void updateProfileTest() {
		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa2@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertTrue(d.UpdateProfileUser(newStudent));
	  }
	  @Test
	  public void resetLimitTest() {
		  UserDAO d=new UserDAO();
		  assertTrue(d.UpdateResetLimitDownloadStudent("m.derosa3@studenti.unisa.it"));
	  }
	  
}
