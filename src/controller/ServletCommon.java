package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfacce.UserInterface;
import model.Studente;


@WebServlet("/ServletCommon")
public class ServletCommon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCommon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
<<<<<<< HEAD
		System.out.println(flag);
	    Connection conn = new DbConnection().getInstance().getConn();
	    String sql = "";
	    
	    if (flag == 1) { // Login
	        String email = request.getParameter("e-mail");
	        String password = request.getParameter("password");
	        try {
	            sql =
	                " SELECT  name, surname, sex, user_type FROM user "
	                + "WHERE TRIM(LOWER(email)) = TRIM(?) AND TRIM(password) = TRIM(?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email.toLowerCase());
	            stmt.setString(2, password);
	            ResultSet r = stmt.executeQuery();
	            if (r.wasNull()) {
	                error = "Errore nell'esecuzione della Query";
	            } 
	            else {
	            	int count = r.last() ? r.getRow() : 0;
	                if (count == 1) {
	                  UserInterface user = null;
	                  String nome = r.getString("Nome");
	                  String cognome = r.getString("Cognome");
	                  char sesso = r.getString("sesso").charAt(0);
	                  Studente student = new Studente(email, nome, cognome, sesso, password);
	                  request.getSession().setAttribute("student", student);
	                }
	                else {
	                    error = "Username o Password errati.";
	                }
	            }
	        } catch (Exception e) {
	            error += e.getMessage();
	        }
	    } 
=======
		String error = "";
	    PreparedStatement stmt = null;
		Connection connection  = null;
		
		String selectSQL = "SELECT * FROM studente";

		if(flag == 1) { //Login
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(selectSQL);
			} catch(SQLException e) {
				System.out.print(e);
			}
			
		}
>>>>>>> b88939ee801d402607f78ade35b308cd4732f076
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/student/HomeStudent.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}
	    

}
