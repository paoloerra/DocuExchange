package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DAO.ReviewDAO;
import interfaces.ReviewInterface;
import model.Review;

public class ReviewDAOTest {

	@Test
	public void test() {

		ReviewInterface review = new Review(0,"m.derosa102@studenti.unisa.it",38 ,"review prova",3,"Michele de Rosa");
		assertTrue(ReviewDAO.saveReview(review));
	}


}
