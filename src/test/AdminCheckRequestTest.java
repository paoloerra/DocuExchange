package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.DAO.NoteDAO;
import controller.AdminCheckRequest;
import model.Request;
import model.interfaces.NoteInterface;
//vedere errore in db->azzerare ogni volta autoincremento
public class AdminCheckRequestTest {
	  private AdminCheckRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  /**
	   * Before.
	   */
  @Before
  public void setUp() {
    servlet = new AdminCheckRequest();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

	@Test
	public void testVerificaRichiestaAccettata() throws ServletException, IOException { 

	FileInputStream file = new FileInputStream(new File("C:\\Users\\Michele\\Desktop\\prova.pdf"));
	Request newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",0);
	NoteDAO dao=new NoteDAO();
	dao.saveRequest(newNote);
	ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	requests.add(newNote);
	request.getSession().setAttribute("requests", requests);
	request.addParameter("outcome", "1");

	request.getSession().setAttribute("index", 0);
	request.getSession().setAttribute("id",newNote.getId());
	request.addParameter("email", "m.derosa1@studenti.unisa.it");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
	@Test
	public void testVerificaRichiestaRifiutata() throws ServletException, IOException { 

	FileInputStream file = new FileInputStream(new File("C:\\Users\\Michele\\Desktop\\prova.pdf"));
	NoteInterface newNote=new Request(2,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",0);
	NoteDAO dao=new NoteDAO();
	dao.saveRequest(newNote);
	ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	requests.add(newNote);
	request.getSession().setAttribute("requests", requests);
	request.addParameter("outcome", "0");

	request.getSession().setAttribute("index", 0);
	request.addParameter("id", "2");
	request.addParameter("email", "m.derosa1@studenti.unisa.it");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
	}
}
