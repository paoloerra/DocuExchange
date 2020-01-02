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


@WebServlet("/ServletCommon")
public class ServletCommon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCommon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		String error = "";
	    PreparedStatement stmt = null;
		Connection connection  = null;
		
		String selectSQL = "SELECT * FROM studente";

		if(flag == 1) { //Login
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email);
			try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(selectSQL);
			} catch(SQLException e) {
				System.out.print(e);
			}
			
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/student/HomeStudent.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}
	    

}
