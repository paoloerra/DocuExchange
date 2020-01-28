package model.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Note;
import model.Request;
import model.interfaces.NoteInterface;
import model.interfaces.NoteInterfaceDAO;

public class NoteDAO implements NoteInterfaceDAO {
	
	private static final String INSERT_REQUEST_SQL = "INSERT INTO Note (Course, Professor, Description, Email_User, FilePDF , Autor, Checked) VALUES (?, ?, ?, ?, ?, ?, 0)";
	private static final String SELECT_NOTE_SQL = "SELECT * from note WHERE Checked = 1;";
	private static final String SELECT_NOTE_STUDENT_SQL = "SELECT * from note WHERE Email_user = ? AND Checked = 1;";
	private static final String SELECT_MY_NOTE_SQL = "SELECT * from note WHERE Email_User = ?;";
	private static final String SELECT_SEARCH_NOTE_SQL = "SELECT * from note WHERE Course = ? AND Professor = ? AND Checked = 1;";
	private static final String SELECT_REQUEST_SQL = "SELECT * from note WHERE Checked = 0;";
	private static final String UPDATE_REQUEST_ACCEPT_SQL = "UPDATE note SET Checked = 1 WHERE ID_Note = ?;";
	private static final String UPDATE_REQUEST_RIFIUTED_SQL = "DELETE FROM note WHERE ID_Note = ?";
	private static final String SELECT_SEARCH_REQUEST_SQL = "SELECT * from Note WHERE Autor = ? AND Checked = 0";
	private static final String DOWNLOAD_NOTE_SQL = "SELECT * from note WHERE ID_Note = ?;";

	private static Connection connection  = null;
	private static PreparedStatement stmt = null;
	
	/**
	 * Insert a request into the database
	 * 
	 * @param request
	 * @return true if the operation was successful
	 * @return false if the operation failed
	 */
	public boolean saveRequest(NoteInterface request) {
		System.out.println("SaveRequest chiamata");
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(INSERT_REQUEST_SQL);
				stmt.setString(1, request.getCourse());
				stmt.setString(2, request.getProfessor());
				stmt.setString(3, request.getDescription());
				stmt.setString(4, request.getStudentEmail());
				stmt.setBinaryStream(5, request.getFile());
				stmt.setString(6, request.getAutor());
				System.out.println(stmt.toString());
				if (stmt.executeUpdate() > 0) {
					connection.commit();
					return true;
			    } else {
			    	return false;
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * Get all the notes from the database
	 * @return List of note
	 */
	public ArrayList<NoteInterface> selectNote(){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_NOTE_SQL);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Note();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(1);
					notes.add(n);
				}
				connection.commit();
				return notes;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Select all the notes of a specific student
	 * 
	 * @param email is the email of student
	 * @return list of note
	 */
	public ArrayList<NoteInterface> selectNoteStudent(String email){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_NOTE_STUDENT_SQL);
		        stmt.setString(1, email);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Note();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(1);
					notes.add(n);
				}
				connection.commit();
				return notes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Select the requests and notes of the student in session
	 * 
	 * @param email is the email of the student in session
	 * @return list the note and the request of the student in the session
	 */
	public ArrayList<NoteInterface> selectMyNote(String email){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_MY_NOTE_SQL);
		        stmt.setString(1, email);
		        System.out.println(stmt.toString());
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Note();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(rs.getInt("Checked"));
					notes.add(n);
				}
				connection.commit();
				return notes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Search for notes by the author's first and last name
	 * 
	 * @param course
	 * @param professor
	 * @return List of note
	 */
	public ArrayList<NoteInterface> SearchNote(String course, String professor){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_SEARCH_NOTE_SQL);
				stmt.setString(1, course);
                stmt.setString(2, professor);
		        System.out.println(stmt.toString());
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Note();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(rs.getInt("Checked"));
					notes.add(n);
				}
				connection.commit();
				return notes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Get all the requests from the database
	 * @return List of request
	 */
	public ArrayList<NoteInterface> selectRequest(){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_REQUEST_SQL);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Request();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(0);
					requests.add(n);
				}
					connection.commit();
					return requests;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * The request is accepted, the checked attribute is set to one.
	 * @param id
	 * @return
	 */
	public boolean UpdateRequestAccept(String id) {
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(UPDATE_REQUEST_ACCEPT_SQL);
				stmt.setString(1, id);
				System.out.println(stmt.toString());
				if (stmt.executeUpdate() > 0) {
					connection.commit();
					return true;
		        } else {
		        	return false;
		        }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * The request is rejected and is deleted from the database
	 *
	 * @param id
	 * @return
	 */
	public boolean UpdateRequestRifiuted(String id) {
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(UPDATE_REQUEST_RIFIUTED_SQL);
				stmt.setString(1, id);
				System.out.println(stmt.toString());
				if (stmt.executeUpdate() > 0) {
					connection.commit();
					return true;
		        } else {
		        	return false;
		        }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * Select the requests and notes of the student in session
	 * 
	 * @param email is the email of the student in session
	 * @return list the note and the request of the student in the session
	 */
	public ArrayList<NoteInterface> selectSearchRequest(String autor){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(SELECT_SEARCH_REQUEST_SQL);
		        stmt.setString(1, autor);
		        System.out.println(stmt.toString());
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface n = new Note();	
					n.setID(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(rs.getInt("Checked"));
					requests.add(n);
				}
				connection.commit();
				return requests;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Select the requests and notes of the student in session
	 * 
	 * @param email is the email of the student in session
	 * @return list the note and the request of the student in the session
	 */
	public InputStream DownloadNote(String id){
		System.out.println("Sono qua");
		InputStream output = null;
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
				stmt = connection.prepareStatement(DOWNLOAD_NOTE_SQL);
		        stmt.setString(1, id);
		        System.out.println(stmt.toString());
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
		        	output = rs.getBinaryStream("FilePDF");
				}
				connection.commit();
				return output;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
