package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentInsertReview;
import controller.StudentSendRequest;
import model.bean.Student;
import model.interfaces.UserInterface;

public class StudentSendRequestTest {

	
	private StudentSendRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
		  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentSendRequest();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	
	
	@Test
	public void TC_1_3_1() throws ServletException, IOException {//non inserito il corso
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","src/test/Test.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test
	public void TC_1_3_2() throws ServletException, IOException { //non inserito il professore
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","src/test/Test.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_3_3() throws ServletException, IOException { //descrizione troppo corta
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","rogrammazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Quest");
		request.addParameter("file_upload","src/test/Test.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_3_4() throws ServletException, IOException { //descrizione troppo lunga
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questa è il corso di POO ."
				+ "...................................................................................."
				+ ".........................................................."
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................");
		request.addParameter("file_upload","src/test/Test.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected=FileNotFoundException.class)
	public void TC_1_3_5() throws ServletException, IOException { //formato non corretto
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","src/test/Test.txt");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	//Richiesta effetuata
	@Test
	public void TC_1_3_6() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","src/test/Test.pdf");
		request.getSession().setAttribute("user", newstudent);
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
}
