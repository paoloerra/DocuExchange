package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.AdminSearchRequest;

public class AdminSearchRequestTest {

	  private AdminSearchRequest servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  /**
	   * Before.
	   */
  @Before
  public void setUp() {
    servlet = new AdminSearchRequest();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
	//Test ricercaRichiesta
	@Test(expected = IllegalArgumentException.class)
	public void	SearchFailName() throws ServletException, IOException { 

		request.addParameter("autor", "Pa");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}

	@Test
	public void SearchSuccess() throws ServletException, IOException { 

		request.addParameter("autor", "Paolo Erra");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void SearchLong() throws ServletException, IOException { 

		request.addParameter("autor", "Paolo Erraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void SearchFormat() throws ServletException, IOException { 

		request.addParameter("autor", "Paolo Erra12");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void SearchEmptyName() throws ServletException, IOException { 
		request.addParameter("autor", "");
		servlet.doPost(request, response);
		assertEquals("json", response.getContentType());
	}
}
