package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import interfacce.UserInterface;
import model.Note;
import model.Studente;



@WebServlet("/ServletStudent")
public class ServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
	    PreparedStatement stmt = null;
		Connection connection  = null;

		int flag = Integer.parseInt(request.getParameter("flag"));
		System.out.println(flag);
		if(flag == 1) { //Registrazione
	        UserInterface user = null;
	        int userType = 0;
			String nome = request.getParameter("nome");
			System.out.println(nome);
			if (nome.length() == 0 || nome.length() > 20 || nome.length() < 2 || nome.matches(".*\\d+.*")) {
				throw new IllegalArgumentException("Formato non corretto");
		        }
			
			String cognome = request.getParameter("cognome");
			System.out.println(cognome);
			if (cognome.length() == 0 || cognome.length() > 20 || cognome.length() < 2 || cognome.matches(".*\\d+.*")) {
				throw new IllegalArgumentException("Formato non corretto");
		        }
			
			 char sesso = request.getParameter("sesso").charAt(0);
			 System.out.println(sesso);
		     if (sesso != 'M' && sesso != 'F') {
		    	 throw new IllegalArgumentException("Valore non corretto");
		     }			
		     
			String email = request.getParameter("email");
			System.out.println(email);
			  String prefix = "";
		        if (email.length() > 0) {
		          prefix = email.substring(0, email.indexOf("@"));
		        }
		        if (email.length() == 0 
		            || !email.endsWith("@studenti.unisa.it") 
		            || prefix.length() < 3 || prefix.indexOf(".") == -1) {
		          throw new IllegalArgumentException("Formato non corretto");
		        }
		        
			String password = request.getParameter("password");
			System.out.println(password);
			if (password.length() < 8) {
				throw new IllegalArgumentException("Formato non corretto");
		    }
			
			String sql = "INSERT INTO User (Email_User, Name, Surname, Password, Sex, type, LimitDownload) VALUES (?, ?, ?, ?, ?, ?, '3')";
			try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, email);
				stmt.setString(2, nome);
				stmt.setString(3, cognome);
				stmt.setString(4, password);
				stmt.setString(5, String.valueOf(sesso));
				stmt.setInt(6, userType);
				if (stmt.executeUpdate() > 0) {
	                redirect = request.getContextPath() + "/student/HomeStudent.jsp";
	                System.out.println(redirect);
					user = new Studente(email, nome, cognome, sesso, password, userType, 3);
	                request.getSession().setAttribute("user", user);
	                content = "Registrazione effettuata correttamente.";
	                result = 1;
	              } else {
	            	  result = 0;
	            	  error = "Impossibile effettuare la registrazione.";
	              }
					connection.commit();
			} catch(SQLException e) {
				System.out.print(e);
			}	
		}
		if(flag == 2) { //Invio richiesta
		   UserInterface student = (UserInterface) request.getSession().getAttribute("user");
	       String email = student.getEmail();
	       String course = request.getParameter("course");
	       String professor = request.getParameter("professor");
	       String description = request.getParameter("description");
	       String file_name = request.getParameter("file_upload");
	       File theFile = new File(file_name);
	       FileInputStream input = new FileInputStream(theFile);
	       		
	       String sql = "INSERT INTO Note (Course, Professor, Description, Email_User, FilePDF , Autor, Checked) VALUES (?, ?, ?, ?, ?, ?, 0)";
	       try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, course);
				stmt.setString(2, professor);
				stmt.setString(3, description);
				stmt.setString(4, email);
				stmt.setBinaryStream(5, input);
				stmt.setString(6, student.getName() +" "+student.getSurname());
				if (stmt.executeUpdate() > 0) {
	                System.out.println(redirect);
	                content = "Invio richiesta effettuato.";
	                result = 1;
	              } else {
	            	  result = 0;
	            	  error = "Errore invio richiesta";
	              }
					connection.commit();
			} catch(SQLException e) {
				System.out.print(e);
			}	
		}
		if(flag == 3) { //Visualizza lista appunti
			System.out.println(flag);
            ArrayList<Note> notes = new ArrayList<Note>();
            String sql = "SELECT * from note WHERE Checked = 1;";
            System.out.println(sql);
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					Note n = new Note();	
					n.setIdNote(rs.getInt("ID_Note"));
					n.setCourse(rs.getString("Course"));
					n.setProfessor(rs.getString("Professor"));
					n.setDescription(rs.getString("Description"));
					n.setStudentEmail(rs.getString("Email_User"));
					n.setAutor(rs.getString("autor"));
					n.setChecked(0);
					n.setFileName("");
					notes.add(n);
				}
				request.getSession().setAttribute("Notes", notes);
				result = 1;
				redirect =  request.getContextPath() + "/student/ListNote.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}	     	
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
