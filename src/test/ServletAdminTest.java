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
	request.addParameter("outcome", "1");
	request.addParameter("index", "0");

	request.getSession().setAttribute("index", 0);
	request.addParameter("id", "36");
	request.addParameter("email", "m.derosa1@studenti.unisa.it");
	request.addParameter("autor", "boh");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	//Test ricercaRichiesta
	@Test(expected = IllegalArgumentException.class)
	public void	TC_1_6_1() throws ServletException, IOException { 

	request.addParameter("autor", "Pa");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_6_2() throws ServletException, IOException { 

	request.addParameter("autor", "Paolo Erraaaaaaaaaaaaaaaaaa");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_6_3() throws ServletException, IOException { 

	request.addParameter("autor", "Paolo Erra12");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_6_4() throws ServletException, IOException { 

	request.addParameter("autor", "Paolo Erra");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test
	public void testCercaRichiestaVuoto() throws ServletException, IOException { 

	request.addParameter("autor", "");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
}