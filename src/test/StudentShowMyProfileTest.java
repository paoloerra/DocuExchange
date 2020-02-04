package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentInsertReview;
import controller.StudentShowMyProfile;
import model.bean.Request;
import model.bean.Student;
import model.interfaces.NoteInterface;
import model.interfaces.UserInterface;

public class StudentShowMyProfileTest {

	  private StudentShowMyProfile servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentShowMyProfile();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	  @Test
		public void VisualizzaProfilo() throws ServletException, IOException { //aggiungere nel db
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}


}
