package test;
//bisogna addatarlo con il documento fatto Login(8 test) Modifica Profilo(da vedere)-> per avere coerenza
import static org.junit.Assert.*;

import controller.ServletCommon;
import interfaces.UserInterface;
import model.Admin;

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
  
  @Test
  public void testUpdate() throws ServletException, IOException {

	  	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it","Filomena", "Ferrucci", 'F', "admin123",1);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("name", "Luigia");
	    request.addParameter("surname", "erra");
	    request.addParameter("password", "admin123");
	    request.addParameter("sex", "M");


	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateFailName() throws ServletException, IOException {
	 	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it","Filomena", "Ferrucci", 'F', "admin123",1);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("name", "");
	    request.addParameter("surname", "erra");
	    request.addParameter("password", "admin123");
	    request.addParameter("sex", "M");
	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
  }
  
 



@Test(expected = IllegalArgumentException.class)
  public void testUpdateFailSurname() throws ServletException, IOException {
	  	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it","Filomena", "Ferrucci", 'F', "admin123",1);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("name", "Luigia");
	    request.addParameter("surname", "");
	    request.addParameter("password", "admin123");
	    request.addParameter("sex", "M");
	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateFailPass() throws ServletException, IOException {
	  	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it","Filomena", "Ferrucci", 'F', "admin123",1);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("name", "Luigia");
	    request.addParameter("surname", "erra");
	    request.addParameter("password", "admin12");
	    request.addParameter("sex", "M");
	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
  }
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateFailSex() throws ServletException, IOException {
	  	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it","Filomena", "Ferrucci", 'F', "admin123",1);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("name", "Luigia");
	    request.addParameter("surname", "erra");
	    request.addParameter("password", "admin123");
	    request.addParameter("sex", "Z");
	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
  }
  
  //studente
  @Test
  public void testLoginStudent() throws ServletException, IOException {
    request.addParameter("email", "m.derosa1@studenti.unisa.it");
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

  @Test
  public void testLogout() throws ServletException, IOException {

	UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it", "Lugia", "Melchionno", 'M', "password", 1);
	request.getSession().setAttribute("user", user);
    request.addParameter("flag", "5");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}