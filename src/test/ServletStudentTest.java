package test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import DAO.DBConnection;
import controller.ServletAdmin;
import controller.ServletCommon;
import controller.ServletStudent;
import interfaces.NoteInterface;
import interfaces.UserInterface;
import model.Note;
import model.Request;
import model.Review;
import model.Student;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ServletStudentTest extends Mockito{
		  private ServletStudent servlet;
		  private MockHttpServletRequest request;
		  private MockHttpServletResponse response;
		 
		  private Connection conn;
		  private String sql;
		  private PreparedStatement stmt;
		  private String mail="m.derosa1@studenti.unisa.it";
		  /**
		   * Before.
		   */
	  @Before
	  public void setUp() {
	    servlet = new ServletStudent();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }

//mettere inserimento e cancellazione traamite email->non messa perchè da errore
	  
	@Test(expected = IllegalArgumentException.class)//nome minore di 2
	public void TC_1_1_1() throws ServletException, IOException { 
		request.addParameter("nome","");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//nome maggiore di 20
	public void TC_1_1_2() throws ServletException, IOException { 
		request.addParameter("nome","Micheleeeeeeeeeeeeeeeeeeeeee");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//Formato non corretto ->nome
	public void TC_1_1_3() throws ServletException, IOException { 
		request.addParameter("nome","Michele1");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//cognome <2
	public void TC_1_1_4() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","d");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//cognome >20
	public void TC_1_1_5() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosaaaaaaaaaaaaaaaaaaaaaaaaaa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)//formato non corretto ->cognome
	public void TC_1_1_6() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa1");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test(expected = IllegalArgumentException.class)//modificare in documentazione
	public void TC_1_1_7() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","Z");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test(expected = IllegalArgumentException.class)//prefisso email<3
	public void TC_1_1_8() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test(expected = IllegalArgumentException.class)//formato non corretto ->email
	public void TC_1_1_9() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@hotmail.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test
	public void TC_1_1_10() throws ServletException, IOException { //se email è gia in db
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test(expected = IllegalArgumentException.class)//password<8
	public void TC_1_11() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abra");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test(expected = IllegalArgumentException.class)//formato non corretto ->password ->aggiungere a servlet non c'è controllo->Aggiunto 
	public void TC_1_1_12() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra?");

		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test//registrazione effettuata
	public void TC_1_1_13() throws ServletException, IOException { 
		request.addParameter("nome","Michele");
		request.addParameter("cognome","de Rosa");
		request.addParameter("email","m.derosa1@studenti.unisa.it");
		request.addParameter("sesso","M");
		request.addParameter("password","Abracadabra");

		request.addParameter("userType","0");
		request.addParameter("flag", "1");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	//fine registrazione


//Testing invio richiesta
	@Test
	public void TC_1_3_1() throws ServletException, IOException {
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	
	@Test
	public void TC_1_3_2() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_3_3() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_3_4() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questa è il corso di POO ."
				+ "...................................................................................."
				+ ".........................................................."
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_3_5() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.txt");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	//Richiesta effetuata
	@Test
	public void TC_1_3_7() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);

		request.addParameter("email","m.derosa1@studenti.unisa.it");;
		request.addParameter("course","Programmazione I");
		request.addParameter("professor","Nappi Michele");
		request.addParameter("description","Questo è il corso di POO");
		request.addParameter("file_upload","C:\\Users\\Michele\\Desktop\\classi.pdf");
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "2");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
//testing lista Richiesta
	@Test
	public void Visulizza_ListaRichiesta() throws ServletException, IOException { //aggiungere appunti in db senno nn va
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello","prog.pdf","boh",1);
		ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
		requests.add(newNote);
		request.getSession().setAttribute("Notes", requests);


		request.addParameter("flag", "3");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}


	@Test
	public void Visulizza_ListaStudenti() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);

		request.addParameter("flag", "4");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test
	public void Visulizza_ProfiloStudente() throws ServletException, IOException { //aggiungere nel db
		Student newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		NoteInterface newNote=new Request(1,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello","prog.pdf","boh",1);
		ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(newstudent);
		requests.add(newNote);
		request.getSession().setAttribute("students", students);

		request.addParameter("index", "0");
		request.getSession().setAttribute("NotesStudent", requests);

		request.getSession().setAttribute("index", 0);

		request.addParameter("flag", "5");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void Visulizza_singoloAppunto() throws ServletException, IOException { //aggiungere review nel db
		Student newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		NoteInterface newNote=new Note(38,"m.derosa1@studenti.unisa.it","Programmazione I","Zizza","è bello","prog.pdf","boh",1);
		
		ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
		
		requests.add(newNote);

		request.addParameter("index", "0");

		request.getSession().setAttribute("Notes", requests);


		request.addParameter("flag", "6");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	
	//test scrivi recensioni
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_4_1() throws ServletException, IOException { //aggiungere review  nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		ArrayList<Review> reviews = new ArrayList<Review>();
		Review r=new Review(1, "m.derosa102@studenti.unisa.it", 38, "adfa", 4,"Michele de Rosa");
		reviews.add(r);
		request.getSession().setAttribute("Reviews", reviews);
		request.addParameter("count", "4");
	
		request.addParameter("review", "");
		request.addParameter("id", "38");

		request.getSession().setAttribute("user", newstudent);


		request.addParameter("flag", "7");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_4_2() throws ServletException, IOException { //aggiungere review  nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		ArrayList<Review> reviews = new ArrayList<Review>();
		Review r=new Review(1, "m.derosa102@studenti.unisa.it", 38, "adfa", 4,"Michele de Rosa");
		reviews.add(r);
		request.getSession().setAttribute("Reviews", reviews);
		request.addParameter("count", "4");
	
		request.addParameter("review", "");
		request.addParameter("id", "38");

		request.getSession().setAttribute("user", newstudent);


		request.addParameter("flag", "7");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = NumberFormatException.class)
	public void TC_1_4_3() throws ServletException, IOException { //aggiungere review  nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		ArrayList<Review> reviews = new ArrayList<Review>();
		Review r=new Review(1, "m.derosa102@studenti.unisa.it", 38, "adfa", 4,"Michele de Rosa");
		reviews.add(r);
		request.getSession().setAttribute("Reviews", reviews);
	
	
		request.addParameter("review", "ottimi appunti ordinati e completi"
				+ "...................................................................................."
				+ ".........................................................."
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................"
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................."
				+ "........................................................");
		request.addParameter("id", "38");

		request.getSession().setAttribute("user", newstudent);


		request.addParameter("flag", "7");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void TC_1_4_4() throws ServletException, IOException { //aggiungere review  nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		ArrayList<Review> reviews = new ArrayList<Review>();
		Review r=new Review(1, "m.derosa102@studenti.unisa.it", 38, "adfa", 4,"Michele de Rosa");
		reviews.add(r);
		request.getSession().setAttribute("Reviews", reviews);
		request.addParameter("count", "4");
	
		request.addParameter("review", "questa è una review");
		request.addParameter("id", "38");

		request.getSession().setAttribute("user", newstudent);


		request.addParameter("flag", "7");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test
	public void VisualizzaProfilo() throws ServletException, IOException { //aggiungere nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);



		request.addParameter("flag", "8");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	//Ricerca Appunti
	@Test
	public void CercaAppunti() throws ServletException, IOException { //aggiungere nel db
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);
		request.addParameter("course","Programmazione I");
		request.addParameter("professor", "Nappi Michele");

		request.addParameter("flag", "9");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	//ricercaStudenti
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_5_1() throws ServletException, IOException {
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);
		request.addParameter("student","Pa");
		
		request.addParameter("flag", "10");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_5_2() throws ServletException, IOException {
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);
		request.addParameter("student","Paolo Erraaaaaaaaaaaaaaaaaaaaa");
		
		request.addParameter("flag", "10");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void TC_1_5_3() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);
		request.addParameter("student","Paolo Erra12");
		
		request.addParameter("flag", "10");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}


	@Test
	public void TC_1_5_4() throws ServletException, IOException { 
		UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
		request.getSession().setAttribute("user", newstudent);
		request.addParameter("student","Paolo Erra");
		
		request.addParameter("flag", "10");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}








}