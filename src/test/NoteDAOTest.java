package test;


import org.junit.Test;

import model.DAO.NoteDAO;

public class NoteDAOTest {

	

	@Test
	public void testInput() {
	NoteDAO n=new NoteDAO();
	n.DownloadNote("1");
	
	
	}

}
