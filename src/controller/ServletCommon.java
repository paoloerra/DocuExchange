package controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

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
		
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");

		
		int flag = Integer.parseInt(request.getParameter("flag"));
		System.out.println(flag);
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
						UserInterface user = new Studente(email_student, name_student, surname_student, sex_student, pass_student, type, 3);
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
			String sql;
		    UserInterface u = (UserInterface) request.getSession().getAttribute("user");
		    int type = u.getUserType();
			String email = request.getParameter("email");
			System.out.println(email);
			String prefix = "";
		    if (email.length() > 0) {
		    	prefix = email.substring(0, email.indexOf("@"));
		    }
		     if (email.length() == 0 || !email.endsWith("@studenti.unisa.it") || prefix.length() < 3 || prefix.indexOf(".") == -1) {
		          throw new IllegalArgumentException("Formato non corretto");
		        }
			String name = request.getParameter("name");
			System.out.println(name);
			if (name.length() == 0 || name.length() > 20 || name.length() < 2 || name.matches(".*\\d+.*")) {
				error = "nome non corretto";
				result = 0;
				throw new IllegalArgumentException("Formato non corretto");
		     }
			String surname = request.getParameter("surname");
			if (surname.length() == 0 || surname.length() > 20 || surname.length() < 2 || surname.matches(".*\\d+.*")) {
				throw new IllegalArgumentException("Formato non corretto");
		     }
			System.out.println(surname);
			String password = request.getParameter("password");
			System.out.println(password);
			if (password.length() < 8) {
				throw new IllegalArgumentException("Formato non corretto");
		    }
			char sex = request.getParameter("sex").charAt(0);
			if (sex != 'M' && sex != 'F') {
				throw new IllegalArgumentException("Valore non corretto");
			 }			
			     
			System.out.println(sex);
			
			sql = "UPDATE user SET Name = ?, Surname = ?, Sex = ?, Password = ?, Email_user = ? WHERE email_user = ? AND Type = ?;";
		    try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, surname);
				stmt.setString(3, String.valueOf(sex));
				stmt.setString(4, password);
				stmt.setString(5, email);
				stmt.setString(6, email);
				stmt.setInt(7, type);

				if(stmt.executeUpdate() == 1) {
					result = 1;
					content = "Modifica effettuata";
				}
				else {
					result = 0;
					error = "Modifica non effettuata";
				}
				connection.commit();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		if(flag == 3) { //Lista studenti
            redirect = request.getContextPath() + "/student/ListStudent.jsp";            
            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
            String emailUser = userS.getEmail();
            System.out.println(emailUser);
            String sql = "SELECT * from user WHERE Type = 0 AND email_user != ?;";
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, emailUser);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					UserInterface student = new Studente();	
					student.setName(rs.getString("Name"));
					student.setSurname(rs.getString("Surname"));
					student.setEmail(rs.getString("Email_User"));
					student.setSex(rs.getString("sex").charAt(0));
					student.setPassword("");
					students.add(student);
				}
				System.out.println(students.size());
				request.getSession().setAttribute("students", students);
				result = 1;
				content = "ok";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag == 4) { //Visualizza profilo di uno studente
			ArrayList<UserInterface> students = (ArrayList<UserInterface>) request.getSession().getAttribute("students");
			int index = Integer.parseInt(request.getParameter("index"));
			System.out.println(index);
			UserInterface student = students.get(index);
			if(student != null) {
				System.out.println(student.getName());
				request.getSession().setAttribute("profile", student);
				result = 1;
		        redirect = request.getContextPath() + "/student/ProfileStudent.jsp";  
			} else {
				result = 1;
				error = "Errore visualizzazione profilo";
			}
		}
		if(flag == 5) { //Logout
            redirect = request.getContextPath() + "/Index.jsp";  
            request.getSession().removeAttribute("user");
            request.getSession().invalidate();
            result = 1;
            content = "Logout effettuato";
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
