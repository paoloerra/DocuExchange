package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.AdminShowRequest;
import model.Request;
import model.interfaces.NoteInterface;

public class AdminShowRequestTest {
	  private AdminShowRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  /**
	   * Before.
	   */
  @Before
  public void setUp() {
    servlet = new AdminShowRequest();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  

@Test
public void testSingolaRichiesta() throws ServletException, IOException { 

	FileInputStream file = new FileInputStream(new File("C:\\Users\\Michele\\Desktop\\prova.pdf"));
	NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",0);
	ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	requests.add(newNote);
	request.getSession().setAttribute("requests", requests);
	request.addParameter("index", "0");
	servlet.doPost(request, response);
	assertEquals("json", response.getContentType());
}

}
