package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.DBConnection;

public class DBConnectionTest {

	 @Test
	  public void testgetConn() throws SQLException {
	    assertNotEquals(null, DBConnection.getConnection());
	  }
}
