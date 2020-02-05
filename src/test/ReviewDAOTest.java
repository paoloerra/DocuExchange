package test;


import org.junit.Test;

import model.DAO.ReviewDAO;
import model.bean.Review;
import model.interfaces.ReviewInterface;

public class ReviewDAOTest {
	@Test
	public void saveReviewTest() {
		ReviewDAO r=new ReviewDAO();
		ReviewInterface review = new Review(0,"m.derosa102@studenti.unisa.it",38 ,"review prova",3,"Michele de Rosa");
		r.saveReview(review);
	}
	@Test
	public void saveReviewTest_fail() {
		ReviewDAO r=new ReviewDAO();
		ReviewInterface review = new Review(0,"m.derosa102@studenti.unisa.it",9999 ,"review prova",3,"Michele de Rosa");
		r.saveReview(review);
	}

	@Test
	public void selectReviewtest() {
		ReviewDAO r=new ReviewDAO();
			r.selectReview(1);
	}


}
