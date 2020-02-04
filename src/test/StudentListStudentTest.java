package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentInsertReview;
import controller.StudentListStudent;
import model.bean.Student;
import model.interfaces.UserInterface;

public class StudentListStudentTest {

	private StudentListStudent servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentListStudent();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	  
	  
	  @Test
		public void Visulizza_ListaStudenti() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
}
