package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.CommonLogin;

public class CommonLoginTest {

	 private CommonLogin servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new CommonLogin();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	//admin
	  
	  @Test
	  public void testLoginAdmin() throws ServletException, IOException {
	    request.addParameter("email", "f.ferrucci1@studenti.unisa.it");
	    request.addParameter("password", "admin123");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_1() throws ServletException, IOException {//email sbagliata->troppo corto il campo prima
	    request.addParameter("email", "m.@studenti.unisa.it");
	    request.addParameter("password", "Abracadabra");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_2() throws ServletException, IOException {//email sbagliata->troppo lungo il campo prima
	    request.addParameter("email", "m.@studenti.unisa.it");
	    request.addParameter("password", "Abracadabra");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_3() throws ServletException, IOException {//email sbagliata->formato
	    request.addParameter("email", "m.derosa1@hotmail.it");
	    request.addParameter("password", "Abracadabra");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_4() throws ServletException, IOException {//utente non esiste
	    request.addParameter("email", "m.derosa00@studenti.unisa.it");
	    request.addParameter("password", "Abracadabra");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_5() throws ServletException, IOException {//Password corta
	    request.addParameter("email", "m.derosa1@studenti.unisa.it");
	    request.addParameter("password", "Abra");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_6() throws ServletException, IOException {//formato password sbagliata
		request.addParameter("email", "m.derosa1@studenti.unisa.it");
		request.addParameter("password", "Abracadabra?");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
	  @Test(expected=NullPointerException.class)
	  public void TC_1_2_7() throws ServletException, IOException {//password sbagliata non esiste nel db
		request.addParameter("email", "m.derosa1@studenti.unisa.it");
		request.addParameter("password", "Abracadabr");
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }//errore nel db
	  @Test
	  public void TC_1_2_8() throws ServletException, IOException { //login effettuato
		  request.addParameter("email", "m.derosa102@studenti.unisa.it");
		  request.addParameter("password", "Abracadabra");
		  servlet.doGet(request, response);
		  assertEquals("json", response.getContentType());
	  }
}
