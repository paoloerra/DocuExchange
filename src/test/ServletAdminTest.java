package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletAdmin;
import controller.ServletCommon;
import interfaces.NoteInterface;
import model.Note;
import model.Request;

public class ServletAdminTest extends Mockito{
		  private ServletAdmin servlet;
		  private MockHttpServletRequest request;
		  private MockHttpServletResponse response;

		  /**
		   * Before.
		   */
	  @Before
	  public void setUp() {
	    servlet = new ServletAdmin();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  

	@Test
	public void testVisualizzaRichieste() throws ServletException, IOException { 
		
	
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test
	public void testSingolaRichiesta() throws ServletException, IOException { 

	NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello","prog.pdf","boh",0);
	ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	requests.add(newNote);
	request.getSession().setAttribute("requests", requests);
	request.addParameter("index", "0");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test
	public void testVerificaRichiesta() throws ServletException, IOException { 

	NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello","prog.pdf","boh",0);
	ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	requests.add(newNote);
	request.getSession().setAttribute("requests", requests);
	request.addParameter("index", "0");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
}
