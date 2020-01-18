package test;
//bisogna addatarlo con il documento fatto Login(8 test) Modifica Profilo(da vedere)-> per avere coerenza
import static org.junit.Assert.*;

import controller.ServletCommon;
import interfaces.UserInterface;
import model.Admin;
import model.Student;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletCommonTest extends Mockito {
  private ServletCommon servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletCommon();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  
  
//admin
  
  @Test
  public void testLoginAdmin() throws ServletException, IOException {
    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
    request.addParameter("password", "admin123");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  //studente
  @Test
  public void testLoginStudent() throws ServletException, IOException {
    request.addParameter("email", "m.derosa102@studenti.unisa.it");
    request.addParameter("password", "Abracadabra");
    request.addParameter("flag", "1");
    servlet.doGet(request, response);
    assertEquals("json", response.getContentType());
  }
  //da qui vedere 
  @Test
  public void testLoginFail() throws ServletException, IOException {
    request.addParameter("email", "a.prova@studenti.unisa.it");
    request.addParameter("password", "passwordsbagliata");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  public void testLoginErrorType() throws ServletException, IOException {
    request.addParameter("email", "loginerror@studenti.unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
//modifica profilo
  @Test(expected = IllegalArgumentException.class)//nome minore di 2
	public void TC_1_7_1() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","M");
		
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//nome maggiore di 20
	public void TC_1_7_2() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Micheleeeeeeeeeeeeeeeeeeeeee");
		

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//Formato non corretto ->nome
	public void TC_1_7_3() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele1");
	
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//cognome <2
	public void TC_1_7_4() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","d");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abracadabra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//cognome >20
	public void TC_1_7_5() throws ServletException, IOException { 
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
	public void TC_1_7_6() throws ServletException, IOException { 
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
	public void TC_1_7_7() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.@studenti.unisa.it");
		request.addParameter("sex","Z");
		request.addParameter("password","Abracadabra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test(expected = IllegalArgumentException.class)//prefisso email<3
	public void TC_1_7_8() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.@studenti.unisa.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abracadabra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test(expected = IllegalArgumentException.class)//formato non corretto ->email
	public void TC_1_7_9() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.derosa1@hotmail.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abracadabra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	

	@Test(expected = IllegalArgumentException.class)//password<8
	public void TC_1_7_10() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test(expected = IllegalArgumentException.class)//formato non corretto ->password ->aggiungere a servlet non c'è controllo->Aggiunto 
	public void TC_1_7_12() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abracadabra?");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test//Modifica effettuata
	public void TC_1_7_13() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa1@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user",newstudent);
		request.addParameter("name","Michele");
		request.addParameter("surname","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sex","M");
		request.addParameter("password","Abracadabra");
		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
  @Test
  public void testLogout() throws ServletException, IOException {

	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it", "Lugia", "Melchionno", 'M', "password", 1);
	request.getSession().setAttribute("user", user);
    request.addParameter("flag", "5");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}