package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.DAO.NoteDAO;

public class NoteDAOTest {

	

	@Test
	public void testInput() {
	NoteDAO n=new NoteDAO();
	n.DownloadNote("1");
	
	
	}

}
