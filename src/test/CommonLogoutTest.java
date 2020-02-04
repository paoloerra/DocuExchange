package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.CommonLogout;
import model.bean.Admin;
import model.interfaces.UserInterface;

public class CommonLogoutTest {

	 private CommonLogout servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new CommonLogout();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  

	  @Test
	  public void testLogout() throws ServletException, IOException {

		UserInterface user = new Admin("f.ferrucci1@studenti.unisa.it", "Lugia", "Melchionno", 'M', "password", 1);
		request.getSession().setAttribute("user", user);
	    servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	  }
}
