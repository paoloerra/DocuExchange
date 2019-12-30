package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	    String error = "";
	    PreparedStatement stmt = null;
	    System.out.println("Sono qui");
		int flag = Integer.parseInt(request.getParameter("flag"));
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/student/HomeStudent.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
	    

}
