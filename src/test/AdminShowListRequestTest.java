package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.AdminShowListRequest;

public class AdminShowListRequestTest {

	  private AdminShowListRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  /**
	   * Before.
	   */
  @Before
  public void setUp() {
    servlet = new AdminShowListRequest();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void testVisualizzaRichieste() throws ServletException, IOException { 
	  servlet.doPost(request, response);
	  assertEquals("json", response.getContentType());
  }
}
