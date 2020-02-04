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

import controller.StudentShowNote;
import model.bean.Note;
import model.bean.Student;
import model.interfaces.NoteInterface;


public class StudentShowNoteTest {

	  private StudentShowNote servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentShowNote();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }

		@Test
		public void Visulizza_singoloAppunto() throws ServletException, IOException { //aggiungere review nel db
			FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
			NoteInterface newNote=new Note(38,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",1);
			ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
			requests.add(newNote);
			request.addParameter("index", "0");
			request.getSession().setAttribute("Notes", requests);
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
}
