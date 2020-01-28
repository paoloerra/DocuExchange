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

import controller.StudentShowProfile;
import model.Request;
import model.Student;
import model.interfaces.NoteInterface;

public class StudentShowProfileTest {

	  private StudentShowProfile servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentShowProfile();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }

	@Test
	public void Visulizza_ProfiloStudente() throws ServletException, IOException { //aggiungere nel db
		Student newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello",file,"boh",1);
		ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(newstudent);
		requests.add(newNote);
		request.getSession().setAttribute("students", students);
		request.addParameter("index", "0");
		request.getSession().setAttribute("NotesStudent", requests);
		request.getSession().setAttribute("index", 0);
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

}
