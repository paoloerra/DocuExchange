package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfacce.UserInterface;
import model.Admin;
import model.Studente;


@WebServlet("/ServletCommon")
public class ServletCommon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCommon() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sono quii");
    	String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
	    PreparedStatement stmt = null;
		Connection connection  = null;

		int flag = Integer.parseInt(request.getParameter("flag"));
		if (flag == 1) { // login
			String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    try {
		    	String sql ="select * from User WHERE Email_User=? AND Password=?"; 
		        connection = DBConnection.getConnection();
		        stmt = connection.prepareStatement(sql);
		        stmt.setString(1, email);
		        stmt.setString(2, password);
		        System.out.println(stmt.toString());
		        ResultSet r = stmt.executeQuery();
		        int count = 0;
				while(r.next()){
					count++;
					int type = r.getInt("Type");
					if(type == 0) {
						String email_student = r.getString("Email_User");
						String pass_student = r.getString("Password");
						String name_student = r.getString("Name");
						String surname_student = r.getString("Surname");
						char sex_student = r.getString("Sex").charAt(0);
						UserInterface user = new Studente(email_student, name_student, surname_student, sex_student, pass_student, type);
		                redirect = request.getContextPath() + "/student/HomeStudent.jsp";
		                request.getSession().setAttribute("user", user);
		                content = "Login corretto.";
		                result = 1;
					}
					else if(type == 1) {
						String email_admin = r.getString("Email_User");
						String pass_admin = r.getString("Password");
						String name_admin = r.getString("Name");
						String surname_admin = r.getString("Surname");
						char sex_admin = r.getString("Sex").charAt(0);
						UserInterface user = new Admin(email_admin, name_admin, surname_admin, sex_admin, pass_admin, type);
		                redirect = request.getContextPath() + "/admin/HomeAdmin.jsp";
		                request.getSession().setAttribute("user", user);
		                content = "Login corretto.";
		                result = 1;
					}
				}
				if(count != 1) {
					error = "Login fallito.";
					result = 0;
					System.out.println(error);
				}

		     }
		     catch(SQLException e) {
		    	 System.out.print(e);
		     }	
		}
		if(flag == 2) { //Modifica profilo
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String password = request.getParameter("password");
			char sesso = request.getParameter("sesso").charAt(0);	
			System.out.println(email);
			result = 1;
			content = "ok";
		}
		JSONObject res = new JSONObject();
		res.put("result", result);
		res.put("error", error);
		res.put("content", content);
		res.put("redirect", redirect);
		PrintWriter out = response.getWriter();
		out.println(res);
		response.setContentType("json");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
