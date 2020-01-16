package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Note;
import model.Request;

public class NoteTest {

	Note n=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);


	@Test
	public void RequesEmptyTest(){
		Note n=new Note();
		assertNotNull(n);
	}
	
	
	@Test
	public void getIdTest() { 
		assertEquals(1,n.getId());
		}
	
	@Test
	public void getStudentEmailTest() { 
		assertEquals("aaa@studenti.unisa.it",n.getStudentEmail());
		}

	@Test
	public void getCourseTest() { 
		assertEquals("Programmazione I",n.getCourse());	
	}

	@Test
	public void getProfessorTest() { 
		assertEquals("Nappi Michele",n.getProfessor());	
		}
	
	@Test
	public void getDescriptionTest() {
		assertEquals("descrizione",n.getDescription());	
		}
	
	
	@Test
	public void getFileNameTest() { 
		assertEquals("file.pdf",n.getFileName());	
		}
	
	@Test
	public void getAutorTest() {
		assertEquals("aaa",n.getAutor());	
	}
	
	@Test
	public void getCheckedTest() { 
		assertEquals(1,n.getChecked());
	}
	
	//metodi set
	@Test
	public void setIDTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa",1);
	ns.setID(2);
	assertEquals(2,ns.getId());
	}
	
	@Test
	public void setStudentEmailTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setStudentEmail("bbb@studenti.unisa.it");
	assertEquals("bbb@studenti.unisa.it",ns.getStudentEmail());
		
	}
	
	@Test
	public void setCourseTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setCourse("Metodi Matematici per Informatica");
	assertEquals("Metodi Matematici per Informatica",ns.getCourse());
			
	}
	
	@Test
	public void setProfessorTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setProfessor("De Felice Clelia");
	assertEquals("De Felice Clelia",ns.getProfessor());
	}
	
	@Test
	public void setDescriptionTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setDescription("Altra descrizione");
	assertEquals("Altra descrizione",ns.getDescription());
	}
	
	@Test
	public void setFileNameTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setFileName("altroFile.pdf");
	assertEquals("altroFile.pdf",ns.getFileName());
		
	}
	
	@Test
	public void setAutorTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setAutor("bbb");;
	assertEquals("bbb",ns.getAutor());
	}

	@Test
	public void setCheckedTest() {
	Note ns=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione","file.pdf", "aaa", 1);
	ns.setChecked(0);;
	assertEquals(0,ns.getChecked());
	}
}
