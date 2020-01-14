package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Admin;
import model.Student;

public class AdminTest extends Mockito{

	 @Test
	 public void testAdminCostructorEmpty() {
	    Admin ad = new Admin();
	    assertNotNull(ad);
	  }
	  
	  // INIZIO TEST GET

	  @Test
	 public void testGetEmail() {
	    Admin ad = new Admin("aaa@sss.it", "a", "a", 'M', "a", 1);
	    assertEquals("aaa@sss.it", ad.getEmail());
	  }

	  @Test
	  public void testGetName() {
	    Admin ad = new Admin("aaa@sss.it", "Michele", "", 'M', "", 1);
	    assertEquals("Michele", ad.getName());
	  }

	  @Test
	  public void testGetSurname() {
	    Admin ad = new Admin("aaa@sss.it", "", "de Rosa", 'm', "", 1);
	    assertEquals("de Rosa", ad.getSurname());
	  }

	  @Test
	  public void testGetSex() {
	    Admin ad = new Admin("aaa@sss.it", "", "", 'M', "", 1);
	    assertEquals('M', ad.getSex());
	  }

	  @Test
	  public void testGetPassword() {
	    Admin ad = new Admin("aaa@sss.it", "", "", 'M', "prova123", 1);
	    assertEquals("prova123", ad.getPassword());
	  }

	  @Test
	  public void testGetUserType() {
	    Admin ad = new Admin("aaa@sss.it", "", "", 'M', "", 1);
	    assertEquals(1, ad.getUserType());
	  }

	  // FINE TEST GET

	  // INIZIO TEST SET

	  @Test
	  public void testSetEmail() {
	    Admin ad = new Admin("aaa@sss.it", "", "", 'M', "", 1);
	    ad.setEmail("aaa");
	    assertEquals("aaa", ad.getEmail());
	  }

	  @Test
	  public void testSetName() {
		Admin ad = new Admin("aaa@sss.it", "Michele", "", 'M', "", 1);
	    ad.setName("Paolo");
	    assertEquals("Paolo", ad.getName());
	  }

	  @Test
	  public void testSetSurname() {
	    Admin ad = new Admin("aaa@sss.it", "", "de Rosa", 'M', "", 1);
	    ad.setSurname("Erra");
	    assertEquals("Erra", ad.getSurname());
	  }

	  @Test
	  public void testSetSex() {
		Admin ad = new Admin("aaa@sss.it", "", "", 'M', "", 1);
		ad.setSex('F');
	    assertEquals('F', ad.getSex());
	  }

	  @Test
	  public void testSetPassword() {
		Admin ad = new Admin("aaa@sss.it", "", "", 'M', "prova123", 1);
		ad.setPassword("pass123");
	    assertEquals("pass123", ad.getPassword());
	  }

	  @Test
	  public void testSetUserType() {
		Admin ad = new Admin("aaa@sss.it", "", "", 'M', "", 1);
		ad.setUserType(01);
	    assertEquals(01, ad.getUserType());
	  }

	  // FINE TEST SET

	

}
