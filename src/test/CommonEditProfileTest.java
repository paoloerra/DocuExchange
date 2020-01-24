package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.CommonEditProfile;
import interfaces.UserInterface;
import model.Student;

public class CommonEditProfileTest {

	 private CommonEditProfile servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new CommonEditProfile();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	//modifica profilo
	  @Test(expected = IllegalArgumentException.class)//nome minore di 2
		public void TC_1_8_1() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","M");		
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//nome maggiore di 20
		public void TC_1_8_2() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Micheleeeeeeeeeeeeeeeeeeeeee");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//Formato non corretto ->nome
		public void TC_1_8_3() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele1");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//cognome <2
		public void TC_1_8_4() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","d");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//cognome >20
		public void TC_1_8_5() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosaaaaaaaaaaaaaaaaaaaaaaaaaa");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			request.addParameter("flag", "2");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//formato non corretto ->cognome
		public void TC_1_8_6() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa1");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			request.addParameter("flag", "2");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		@Test(expected = IllegalArgumentException.class)//modificare in documentazione
		public void TC_1_8_7() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.@studenti.unisa.it");
			request.addParameter("sex","Z");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test(expected = IllegalArgumentException.class)//prefisso email<3
		public void TC_1_8_8() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test(expected = IllegalArgumentException.class)//formato non corretto ->email
		public void TC_1_8_9() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.derosa1@hotmail.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		

		@Test(expected = IllegalArgumentException.class)//password<8
		public void TC_1_8_10() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		@Test(expected = IllegalArgumentException.class)//formato non corretto ->password 
		public void TC_1_8_12() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra?");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test//Modifica effettuata
		public void TC_1_8_13() throws ServletException, IOException { 
			UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			request.getSession().setAttribute("user",newstudent);
			request.addParameter("name","Michele");
			request.addParameter("surname","de Rosa");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sex","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

}
