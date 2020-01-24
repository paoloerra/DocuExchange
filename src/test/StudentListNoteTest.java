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

import controller.StudentInsertReview;
import controller.StudentListNote;
import interfaces.NoteInterface;
import interfaces.UserInterface;
import model.Request;
import model.Student;

public class StudentListNoteTest {

	private StudentListNote servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentListNote();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }

		@Test
		public void Visulizza_ListaRichiesta() throws ServletException, IOException { //aggiungere appunti in db senno nn va
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

			FileInputStream file = new FileInputStream(new File("C:\\Users\\Michele\\Desktop\\prova.pdf"));
			NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",1);
			ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
			requests.add(newNote);
			request.getSession().setAttribute("Notes", requests);


			request.addParameter("flag", "3");
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
}
