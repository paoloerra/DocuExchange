package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import DAO.UserDAO;
import controller.StudentInsertReview;
import model.Student;
import model.interfaces.UserInterface;

public class UserDAOTest {
	  
	//eliminare 
	
	  @Test
	  public void saveStudentTest() {

		  UserInterface newStudent=new Student("m.derosa3@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertTrue(UserDAO.saveStudent(newStudent));
	  }
	  @Test
	  public void selectStudentTest() {

		  UserInterface newStudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  ArrayList<UserInterface> arr=new ArrayList<UserInterface>();
		  arr.add(newStudent);
		  assertEquals(arr,UserDAO.selectStudent("m.derosa102@studenti.unisa.it"));
	  }
	  @Test
	  public void loginStudentTest() {

		  UserInterface newStudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertEquals(newStudent,UserDAO.SelectLoginUser("m.derosa102@studenti.unisa.it", "Abracadabra"));
	  }
	  @Test
	  public void updateProfileTest() {

		  UserInterface newStudent=new Student("m.derosa2@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  assertTrue(UserDAO.UpdateProfileUser(newStudent));
	  }
	  @Test
	  public void resetLimitTest() {

		  assertTrue(UserDAO.UpdateResetLimitDownloadStudent("m.derosa3@studenti.unisa.it"));
	  }
	  
}
