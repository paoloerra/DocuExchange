package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReviewInterface;
import interfaces.ReviewInterfaceDAO;
import model.Review;

public class ReviewDAO implements ReviewInterfaceDAO{
	
	private static final String SELECT_REVIEW_SQL = "SELECT * from review WHERE ID_Note = ?;";
	private static final String INSERT_REVIEW_SQL = "INSERT INTO Review (Comment, Stars, Email_User, ID_Note, Autor) VALUES (?, ?, ?, ?, ?);";

	private static Connection connection  = null;
	private static PreparedStatement stmt = null;
	
	/**
	 * Select all the reviews of a specific note
	 * 
	 * @param id is the id of the note
	 * @return list of review
	 */
	public ArrayList<ReviewInterface> selectReview(int id){
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
	            ArrayList<ReviewInterface> reviews = new ArrayList<ReviewInterface>();
				stmt = connection.prepareStatement(SELECT_REVIEW_SQL);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					
					ReviewInterface review = new Review();
					review.setComment(rs.getString("Comment"));
					review.setStar(rs.getInt("Stars"));
					review.setAutor(rs.getString("Autor"));
					reviews.add(review);
				}			
				connection.commit();
				return reviews;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * inserting a review into the database
	 * 
	 * @param review is the review to be included.
	 * @return true if the operation was successful
	 * @return false if the operation failed
	 */
	public boolean saveReview(ReviewInterface review) {
		System.out.println("SaveReview chiamata");
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				stmt = connection.prepareStatement(INSERT_REVIEW_SQL);
				stmt.setString(1, review.getComment());
				stmt.setInt(2, review.getStar());
				stmt.setString(3, review.getStudentEmail());
				stmt.setInt(4, review.getIdNote());
				stmt.setString(5, review.getAutor());
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
