package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.Test;
import model.bean.Note;

public class NoteTest {

	@Test
	public void NoteEmptyTest(){
		Note n=new Note();
		assertNotNull(n);
	}

	@Test
	public void getIdTest() throws FileNotFoundException { 
		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals(1,r.getId()); 
	}
	@Test
	public void getStudentEmailTest() throws FileNotFoundException { 
		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);

		assertEquals("aaa@studenti.unisa.it",r.getStudentEmail());
	}
	@Test
	public void getCourseTest() throws FileNotFoundException  { 

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals("Programmazione I",r.getCourse());	}

	
	@Test
	public void getProfessorTest() throws FileNotFoundException  { 

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals("Nappi Michele",r.getProfessor());	
		}
	
	@Test
	public void getDescriptionTest() throws FileNotFoundException  {


		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals("descrizione",r.getDescription());	
		}
	
	
	@Test
	public void getFileNameTest() throws FileNotFoundException  {

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals(file,r.getFile());	}
	

	@Test
	public void getAutorTest() throws FileNotFoundException { 

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals("aaa",r.getAutor());	
		}
	
	@Test
	public void getCheckedTest() throws FileNotFoundException { 


		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note r=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
		assertEquals(0,r.getChecked());
		}
	
	//metodi set
	@Test
	public void setIDTest() throws FileNotFoundException{

	FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setID(2);
	assertEquals(2,rs.getId());
	}
	
	@Test
	public void setStudentEmailTest() throws FileNotFoundException{


		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setStudentEmail("bbb@studenti.unisa.it");
	assertEquals("bbb@studenti.unisa.it",rs.getStudentEmail());
		
	}
	
	@Test
	public void setCourseTest() throws FileNotFoundException{

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setCourse("Metodi Matematici per Informatica");
	assertEquals("Metodi Matematici per Informatica",rs.getCourse());
			
	}
	
	@Test
	public void setProfessorTest() throws FileNotFoundException{

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setProfessor("De Felice Clelia");
	assertEquals("De Felice Clelia",rs.getProfessor());
	}
	
	@Test
	public void setDescriptionTest() throws FileNotFoundException{

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
		Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setDescription("Altra descrizione");
	assertEquals("Altra descrizione",rs.getDescription());
	}
	
	@Test
	public void setFileNameTest() throws FileNotFoundException{

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);


	FileInputStream file1 = new FileInputStream(new File("src/test/Test.pdf"));
	rs.setFile(file1);
	assertEquals(file1,rs.getFile());
		
	}
	
	@Test
	public void setAutorTest() throws FileNotFoundException{

		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);
	rs.setAutor("bbb");;
	assertEquals("bbb",rs.getAutor());
	}

	@Test
	public void setCheckedTest() throws FileNotFoundException{


		FileInputStream file = new FileInputStream(new File("src/test/Test.pdf"));
	Note rs=new Note(1,"aaa@studenti.unisa.it","Programmazione I","Nappi Michele", "descrizione",file, "aaa", 0);	
	rs.setChecked(1);;
	assertEquals(1,rs.getChecked());
	}
}
