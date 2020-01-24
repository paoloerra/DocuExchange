package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.StudentInsertReview;
import interfaces.UserInterface;
import model.Review;
import model.Student;

public class StudentInsertReviewTest {
	
	
	  private StudentInsertReview servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	 
	
	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
		  servlet = new StudentInsertReview();
		  request = new MockHttpServletRequest();
		  response = new MockHttpServletResponse();
	  }
	
	
		//test scrivi recensioni
	
		@Test(expected = NumberFormatException.class)
		public void TC_1_5_1() throws ServletException, IOException { //aggiungere review  nel db
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
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
		@Test
		public void TC_1_5_2() throws ServletException, IOException { //aggiungere review  nel db
			UserInterface newstudent=new Student("m.derosa102@studenti.unisa.it","Michele","de Rosa",'M',"Abracadabra",0,3);
			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r=new Review(1, "m.derosa102@studenti.unisa.it", 38, "adfa", 4,"Michele de Rosa");
			reviews.add(r);
			request.getSession().setAttribute("Reviews", reviews);
			request.addParameter("count", "4");
			request.addParameter("review", "questa è una review");
			request.addParameter("id", "38");
			request.getSession().setAttribute("user", newstudent);
			servlet.doPost(request, response);
			assertEquals("json", response.getContentType());
		}
}
