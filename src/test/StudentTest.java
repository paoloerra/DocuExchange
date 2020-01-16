package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Admin;
import model.Student;

public class StudentTest {
	
	Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
	  
	
	  @Test
	  public void testAdminCostructorEmpty() {
		Student s=new Student();
	    assertNotNull(s);
	  }
	  
	  // INIZIO TEST GET

	  @Test
	  public void testGetEmail() {
	    assertEquals("aaa@sss.it", s.getEmail());
	  }

	  @Test
	  public void testGetName() {
	    assertEquals("Michele", s.getName());
	  }

	  @Test
	  public void testGetSurname() {
	    assertEquals("de Rosa", s.getSurname());
	  }

	  @Test
	  public void testGetSex() {
	    assertEquals('M', s.getSex());
	  }

	  @Test
	  public void testGetPassword() {
	    assertEquals("prova123", s.getPassword());
	  }

	  @Test
	  public void testGetUserType() {
	    assertEquals(0, s.getUserType());
	  }
	  public void getLimitDownloadTest() {
		assertEquals(3, s.getLimitDownload());
	  }

	  // FINE TEST GET

	  // INIZIO TEST SET

	  @Test
	  public void testSetEmail() {
		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
	    s.setEmail("aaa");
	    assertEquals("aaa", s.getEmail());
	  }

	  @Test
	  public void testSetName() {

		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
	    s.setName("Paolo");
	    assertEquals("Paolo", s.getName());
	  }

	  @Test
	  public void testSetSurname() {

		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
	    s.setSurname("Erra");
	    assertEquals("Erra", s.getSurname());
	  }

	  @Test
	  public void testSetSex() {

		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
		s.setSex('F');
	    assertEquals('F', s.getSex());
	  }

	  @Test
	  public void testSetPassword() {

		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
		s.setPassword("pass123");
	    assertEquals("pass123", s.getPassword());
	  }

	  @Test
	  public void testSetUserType() {
		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
		s.setUserType(01);
	    assertEquals(01, s.getUserType());
	  }

	  @Test
	  public void setLimitDownloadTest() {
		Student s= new Student("aaa@sss.it", "Michele", "de Rosa", 'M', "prova123", 0,3);
		s.setLimitDownload(2);
		assertEquals(2, s.getLimitDownload());
	  }
}
