package test;
//bisogna addatarlo con il documento fatto Login(8 test) Modifica Profilo(da vedere)-> per avere coerenza
import static org.junit.Assert.*;

import controller.DownloaderServlet;
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

public class DownloadServletTest extends Mockito {
  private DownloaderServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new DownloaderServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  
  
//admin
  //aggiunger in db la richiesta ->fare query
  @Test
  public void DownloadAdmin() throws ServletException, IOException {


    request.addParameter("id", "77");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
  }
  
  @Test
  public void DownloadStudente() throws ServletException, IOException {

		UserInterface user=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
	    request.getSession().setAttribute("user", user);
	    request.addParameter("id", "77");


	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
  }
  
}