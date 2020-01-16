package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Request;

public class RequestTest extends Mockito {
	Request r=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);


	@Test
	public void RequesEmptyTest(){
		Request r=new Request();
		assertNotNull(r);
	}
	
	@Test
	public void getIdTest() { assertEquals(1,r.getId()); }
	@Test
	public void getStudentEmailTest() { assertEquals("aaa@studenti.unisa.it",r.getStudentEmail());	}
	@Test
	public void getCourseTest() { assertEquals("Programmazione I",r.getCourse());	}

	
	@Test
	public void getProfessorTest() { assertEquals("Nappi Michele",r.getProfessor());	}
	
	@Test
	public void getDescriptionTest() { assertEquals("descrizione",r.getDescription());	}
	
	
	@Test
	public void getFileNameTest() { assertEquals("file.pdf",r.getFileName());	}
	

	@Test
	public void getAutorTest() { assertEquals("aaa",r.getAutor());	}
	
	@Test
	public void getCheckedTest() { assertEquals(0,r.getChecked());}
	
	//metodi set
	@Test
	public void setIDTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setID(2);
	assertEquals(2,rs.getId());
	}
	
	@Test
	public void setStudentEmailTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setStudentEmail("bbb@studenti.unisa.it");
	assertEquals("bbb@studenti.unisa.it",rs.getStudentEmail());
		
	}
	
	@Test
	public void setCourseTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setCourse("Metodi Matematici per Informatica");
	assertEquals("Metodi Matematici per Informatica",rs.getCourse());
			
	}
	
	@Test
	public void setProfessorTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setProfessor("De Felice Clelia");
	assertEquals("De Felice Clelia",rs.getProfessor());
	}
	
	@Test
	public void setDescriptionTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setDescription("Altra descrizione");
	assertEquals("Altra descrizione",rs.getDescription());
	}
	
	@Test
	public void setFileNameTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setFileName("altroFile.pdf");
	assertEquals("altroFile.pdf",rs.getFileName());
		
	}
	
	@Test
	public void setAutorTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setAutor("bbb");;
	assertEquals("bbb",rs.getAutor());
	}

	@Test
	public void setCheckedTest() {
	Request rs=new Request(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 0);
	rs.setChecked(1);;
	assertEquals(1,rs.getChecked());
	}

}
