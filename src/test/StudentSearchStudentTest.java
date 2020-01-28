package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentSearchStudent;
import model.Student;
import model.interfaces.UserInterface;

public class StudentSearchStudentTest {


	  private StudentSearchStudent servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentSearchStudent();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	  
	//ricercaStudenti
		@Test(expected = IllegalArgumentException.class)
		public void TC_1_5_1() throws ServletException, IOException {
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("student","Pa");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)
		public void TC_1_5_2() throws ServletException, IOException {
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("student","Paolo Erraaaaaaaaaaaaaaaaaaaaa");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)
		public void TC_1_5_3() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("student","Paolo Erra12");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test
		public void TC_1_5_4() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.getSession().setAttribute("students",null);
			request.addParameter("student","Paolo Erra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test
		public void SearchStudentEmpty() throws ServletException, IOException {
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("student","");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test
		public void SearchStudentOnlyName() throws ServletException, IOException {
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("student","Paolo");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		
}
