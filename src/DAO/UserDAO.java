package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UserInterface;
import interfaces.UserInterfaceDAO;
import model.Admin;
import model.Student;

public class UserDAO implements UserInterfaceDAO {
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO User (Email_User, Name, Surname, Password, Sex, type, LimitDownload) VALUES (?, ?, ?, ?, ?, ?, '3')";
	private static final String SELECT_STUDENT_SQL = "SELECT * from user WHERE Type = 0 AND email_user != ?;";
	private static final String SELECT_SEARCH_STUDENT_FOR_NAME_AND_SURNAME_SQL = "SELECT * from user WHERE Name = ? AND Surname = ? AND email_user != ? AND Type = 0 ";
	private static final String SELECT_SEARCH_STUDENT_FOR_NAME_SQL = "SELECT * from user WHERE Name = ? AND email_user != ? AND Type = 0;";
	private static final String LOGIN_SQL = "select * from User WHERE Email_User=? AND Password=?;";
	private static final String UPDATE_PROFILE_USER_SQL = "UPDATE user SET Name = ?, Surname = ?, Sex = ?, Password = ? WHERE email_user = ? AND Type = ?;";
	private static final String UPDATE_RESET_LIMIT_DOWNLOAD_SQL = "UPDATE user SET LimitDownload = 3 WHERE Email_User = ?;";
	
	private static Connection connection  = null;
	private static PreparedStatement stmt = null;
	
	/**
	 * Inserting a new student into the database
	 * 
	 * @param user it is the student who must be entered in the database
	 * @return true if the operation was successful
	 * @return false if the operation failed+
	 * */
	public boolean saveStudent(UserInterface user) {
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(INSERT_STUDENT_SQL);
				stmt.setString(1, user.getEmail());
				stmt.setString(2, user.getName());
				stmt.setString(3, user.getSurname());
				stmt.setString(4, user.getPassword());
				stmt.setString(5, String.valueOf(user.getSex()));
				stmt.setInt(6, user.getUserType());
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
	 * View student list except the student in session
	 * 
	 * @param EmailStudentSession is the email of the student in the session
	 * @return List of student
	 */
	public ArrayList<UserInterface> selectStudent(String EmailStudentSession){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
				stmt = connection.prepareStatement(SELECT_STUDENT_SQL);
				stmt.setString(1, EmailStudentSession);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					UserInterface student = new Student();	
					student.setName(rs.getString("Name"));
					student.setSurname(rs.getString("Surname"));
					student.setEmail(rs.getString("Email_User"));
					student.setSex(rs.getString("sex").charAt(0));
					student.setPassword("");
					students.add(student);
				}
				connection.commit();
				return students;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Login
	 * 
	 * @param email 
	 * @param password
	 * @return
	 */
	public UserInterface SelectLoginUser(String email, String password){
		System.out.println("Login");
		try {
			UserInterface user = null;
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
				stmt = connection.prepareStatement(LOGIN_SQL);
				stmt.setString(1, email);
			    stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();	
				int count = 0;
			    while(rs.next()){
			    	count++;
					int type = rs.getInt("Type");
					if(type == 0) {
						String email_student = rs.getString("Email_User");
						String pass_student = rs.getString("Password");
						String name_student = rs.getString("Name");
						String surname_student = rs.getString("Surname");
						int LimitDownload = rs.getInt("LimitDownload");
						char sex_student = rs.getString("Sex").charAt(0);
						user = new Student(email_student, name_student, surname_student, sex_student, pass_student, type, LimitDownload);
					}
					else if(type == 1) {
						String email_admin = rs.getString("Email_User");
						String pass_admin = rs.getString("Password");
						String name_admin = rs.getString("Name");
						String surname_admin = rs.getString("Surname");
						char sex_admin = rs.getString("Sex").charAt(0);
						user = new Admin(email_admin, name_admin, surname_admin, sex_admin, pass_admin, type);
						
					}
					if(count != 1) {
						return null;
					}
				}
			    return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	/**
	 * Select list of students with specified name and surname excluding the student in session
	 * 
	 * @param EmailStudentSession
	 * @return list of student
	 */
	public ArrayList<UserInterface> selectSearchForNameAndSurnameStudent(String name, String surname, String studentSession){
		System.out.println("Name and surname");
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
				stmt = connection.prepareStatement(SELECT_SEARCH_STUDENT_FOR_NAME_AND_SURNAME_SQL);
				stmt.setString(1, name);
                stmt.setString(2, surname);
                stmt.setString(3, studentSession);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					UserInterface student = new Student();	
					student.setName(rs.getString("Name"));
					student.setSurname(rs.getString("Surname"));
					student.setEmail(rs.getString("Email_User"));
					student.setSex(rs.getString("sex").charAt(0));
					student.setPassword("");
					students.add(student);
				}
				if(students.isEmpty()) {
					return null;
				}
				else {
					connection.commit();
					return students;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Select list of students with specified name excluding the student in session
	 * @param name
	 * @param studentSession
	 * @return
	 */
	public ArrayList<UserInterface> selectSearchForNameStudent(String name, String studentSession){
		System.out.println("Name");
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
				stmt = connection.prepareStatement(SELECT_SEARCH_STUDENT_FOR_NAME_SQL);
				stmt.setString(1, name);
                stmt.setString(2, studentSession);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					UserInterface student = new Student();	
					student.setName(rs.getString("Name"));
					student.setSurname(rs.getString("Surname"));
					student.setEmail(rs.getString("Email_User"));
					student.setSex(rs.getString("sex").charAt(0));
					student.setPassword("");
					students.add(student);
				}
				if(students.isEmpty()) {
					return null;
				}
				else {
					connection.commit();
					return students;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Update profile of user.
	 * 
	 * @param user
	 * @return user changed
	 */
	public boolean UpdateProfileUser(UserInterface user) {
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(UPDATE_PROFILE_USER_SQL);
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getSurname());
				stmt.setString(3, String.valueOf(user.getSex()));
				stmt.setString(4, user.getPassword());
				stmt.setString(5, user.getEmail());
				stmt.setInt(6, user.getUserType());
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
	 * Reset limit download of the student
	 * 
	 * @param email is the email of the student
	 */
	public boolean UpdateResetLimitDownloadStudent(String email) {
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(UPDATE_RESET_LIMIT_DOWNLOAD_SQL);
				stmt.setString(1, email);
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
}
