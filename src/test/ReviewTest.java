package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Review;

public class ReviewTest {
	Review rv=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
	@Test
	public void ReviewEmptyTest() {
	Review r=new Review();
	assertNotNull(r);
	}
	
//metodi get
	@Test
	public void getIdReviewTest() { 
	assertEquals(1, rv.getIdReview());	
	}
	
	@Test
	public void getStudentEmailTest() {
		assertEquals("aaa@studenti.unisa.it", rv.getStudentEmail());
	}
	
	@Test
	public void getAutorTest() {
	assertEquals("aaa", rv.getAutor());	
	}
	
	@Test
	public void getCommentTest() {
		assertEquals("commento",rv.getComment());
	}

	@Test
	public void getIdNoteTest() {
		assertEquals(1, rv.getIdNote());
	}
	
	@Test
	public void getStarTest() {
		assertEquals(4,rv.getStar());
	}
//metodi set
	
	@Test
	public void setIdNote() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setIdNote(2);
		assertEquals(2, rs.getIdNote());
	}

	@Test
	public void setCommentTest() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setComment("altro commento");
		assertEquals("altro commento", rs.getComment());

	}

	@Test
	public void setStudentEmailTest() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setStudentEmail("bbb@studenti.unisa.it");
		assertEquals("bbb@studenti.unisa.it", rs.getStudentEmail());

	}
	
	@Test
	public void setStarTest() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setStar(3);;
		assertEquals(3, rs.getStar());

	}
	
	@Test
	public void setIdReviewTest() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setIdReview(2);;
		assertEquals(2, rs.getIdReview());

	}
	
	@Test
	public void setAutorTest() {
		Review rs=new Review(1,"aaa@studenti.unisa.it", 1, "commento", 4,"aaa");
		rs.setAutor("bbb");;
		assertEquals("bbb", rs.getAutor());

	}
	
	
}
