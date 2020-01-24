package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentRegistration;

public class StudentRegistrationTest {
      private StudentRegistration servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	  private Connection conn;
	  private String sql;
	  private PreparedStatement stmt;
	  private String mail="m.derosa1@studenti.unisa.it";
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentRegistration();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	  
		@Test(expected = IllegalArgumentException.class)//nome minore di 2
		public void TC_1_1_1() throws ServletException, IOException { 
			request.addParameter("nome","");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//nome maggiore di 20
		public void TC_1_1_2() throws ServletException, IOException { 
			request.addParameter("nome","Micheleeeeeeeeeeeeeeeeeeeeee");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//Formato non corretto ->nome
		public void TC_1_1_3() throws ServletException, IOException { 
			request.addParameter("nome","Michele1");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//cognome <2
		public void TC_1_1_4() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","d");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//cognome >20
		public void TC_1_1_5() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosaaaaaaaaaaaaaaaaaaaaaaaaaa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test(expected = IllegalArgumentException.class)//formato non corretto ->cognome
		public void TC_1_1_6() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa1");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		@Test(expected = IllegalArgumentException.class)//modificare in documentazione
		public void TC_1_1_7() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","Z");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test(expected = IllegalArgumentException.class)//prefisso email<3
		public void TC_1_1_8() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test(expected = IllegalArgumentException.class)//formato non corretto ->email
		public void TC_1_1_9() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@hotmail.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		@Test
		public void TC_1_1_10() throws ServletException, IOException { //se email è gia in db
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa1@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

		@Test(expected = IllegalArgumentException.class)//password<8
		public void TC_1_11() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abra");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		
		@Test(expected = IllegalArgumentException.class)//formato non corretto ->password ->aggiungere a servlet non c'è controllo->Aggiunto 
		public void TC_1_1_12() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra?");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test//registrazione effettuata
		public void TC_1_1_13() throws ServletException, IOException { 
			request.addParameter("nome","Michele");
			request.addParameter("cognome","de Rosa");
			request.addParameter("email","m.derosa2@studenti.unisa.it");
			request.addParameter("sesso","M");
			request.addParameter("password","Abracadabra");
			request.addParameter("userType","0");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}

}
