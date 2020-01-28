package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import model.Admin;

import model.Student;
import model.interfaces.UserInterface;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.CheckSession;

public class CheckSessionTest {

  @Test
  public void testCheckSessionCostructor() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertNotNull(check);
  }
  
  @Test
  public void testGetSession() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertEquals(session, check.getSession());
  }
  
  @Test
  public void testSetSession() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    HttpSession session1 = request.getSession();
    check.setSession(session1);
    assertEquals(session1, check.getSession());
  }
  
  @Test
  public void testGetUrlRedirect() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertEquals("/index.jsp", check.getUrlRedirect());
  }
  
  @Test
  public void testSetUrlRedirect() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    check.setUrlRedirect("/logout.jsp");
    assertEquals("/logout.jsp", check.getUrlRedirect());
  }
  
  @Test
  public void testGetPageName() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","page1",session);
    assertEquals("page1", check.getPageName());
  }
  
  @Test
  public void testSetPageName() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","page1",session);
    check.setPageName("page2");
    assertEquals("page2", check.getPageName());
  }
  
  @Test
  public void testGetPageFolder() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("folder1","",session);
    assertEquals("folder1", check.getPageFolder());
  }
  
  @Test
  public void testSetPageFolder() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("folder1","",session);
    check.setPageFolder("folder2");
    assertEquals("folder2", check.getPageFolder());
  }
  
  @Test
  public void testIsAllowedStudent() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0,3);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("student","",session);
    assertEquals(true, check.isAllowed());
  }
  

  @Test
  public void testIsAllowedAdmin() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Admin("adm.session@unisa.it", "name", "surname", 'M', "password", 1);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("admin","",session);
    assertEquals(true, check.isAllowed());
  }
  
  @Test
  public void testIsAllowedStudentFail() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0,3);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaStudenti","",session);
    assertEquals(false, check.isAllowed());
  }
  

  
  @Test
  public void testIsAllowedAdminFail() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Admin("adm.session@unisa.it", "name", "surname", 'M', "password", 1);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaAdmino","",session);
    assertEquals(false, check.isAllowed());
  }
  
  @Test
  public void testIsAllowedNull() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0,3);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaStudent","",session);
    assertEquals(false, check.isAllowed());
  }
}
