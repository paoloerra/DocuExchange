package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.DAO.DBConnection;
import model.DAO.UserDAO;
import controller.AdminCheckRequest;
import controller.StudentInsertReview;
import model.bean.Student;
import model.interfaces.UserInterface;

public class UserDAOTest {
	  
	private AdminCheckRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new AdminCheckRequest();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }

	
	  @Test
	  public void saveStudentTest() {

		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa5@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  d.saveStudent(newStudent);
	  }
	  
	  @Test
	  public void selectStudentTest() {

		  UserDAO d=new UserDAO();
		  
		  d.selectStudent("m.derosa102@studenti.unisa.it");
	  }
	  @Test
	  public void loginStudentTest() {
		  UserDAO d=new UserDAO();
		  d.SelectLoginUser("m.derosa102@studenti.unisa.it", "Abracadabra");
	  }
	  @Test
	  public void loginAdminTest() {
		  UserDAO d=new UserDAO();
		  d.SelectLoginUser("a.dmin1@studenti.unisa.it", "prova123");
	  }
	  @Test
	  public void updateProfileTest() {
		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student("m.derosa2@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		  d.UpdateProfileUser(newStudent);
	  }
	  @Test
	  public void updateProfileTest_fail() {
		  UserDAO d=new UserDAO();
		  UserInterface newStudent=new Student();
		  d.UpdateProfileUser(newStudent);
	  }
	  @Test
	  public void select() {
		  UserDAO d=new UserDAO();
		  
		 d.selectSearchForNameAndSurnameStudent("Michele", "de Rosa","");
	  }
	  @Test
	  public void nameTest() {
		  UserDAO d=new UserDAO();
		 d.selectSearchForNameStudent("Paolo","");
	  }
	  @Test
	  public void resetLimitTest() {
		  UserDAO d=new UserDAO();
		 d.UpdateResetLimitDownloadStudent("m.derosa1@studenti.unisa.it");
	  }
	  @Test
	  public void resetLimitTest2() {
		  UserDAO d=new UserDAO();
		 d.UpdateResetLimitDownloadStudent("m.derosa99@studenti.unisa.it");
	  }
	  
	  //
	
}
