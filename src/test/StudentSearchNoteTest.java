package test;

import static org.junit.Assert.*;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentSearchNote;
import model.bean.Student;
import model.interfaces.UserInterface;

public class StudentSearchNoteTest {

	  private StudentSearchNote servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentSearchNote();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }

	  
	  
	//Ricerca Appunti
	  @Test
		public void SearchNoteEmpty() throws ServletException, IOException { //aggiungere nel db
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("course","");
			request.addParameter("professor", "");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test
		public void CercaAppunti() throws ServletException, IOException { //aggiungere nel db
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user", newstudent);
			request.addParameter("course","Programmazione I");
			request.addParameter("professor", "Nappi Michele");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
}
