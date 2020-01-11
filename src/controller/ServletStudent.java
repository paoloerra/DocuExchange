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

import interfaces.NoteInterface;
import interfaces.ReviewInterface;
import interfaces.UserInterface;
import model.Note;
import model.Review;
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
		System.out.println("Sono nella servlet student");
		
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");

		System.out.println("ServletStudent");
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
					SendEmail.SendRequestEmail(email, userS.getName(), course, professor, description);
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
            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
            String sql = "SELECT * from note WHERE Checked = 1;";
            System.out.println(sql);
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
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
				request.getSession().setAttribute("Notes", notes);
				result = 1;
				redirect =  request.getContextPath() + "/student/ListNote.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}	     	
		}
		if(flag == 4) { //Lista studenti
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
		if(flag == 5) { //Visualizza profilo di uno studente
			ArrayList<UserInterface> students = (ArrayList<UserInterface>) request.getSession().getAttribute("students");
			int index = Integer.parseInt(request.getParameter("index"));
			System.out.println(index);
			UserInterface student = students.get(index);
			if(student != null) {
				request.getSession().setAttribute("profile", student);
				//Prelevo i suoi appunti pubblicati
				 ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
		            String sql = "SELECT * from note WHERE Email_user = ? AND Checked = 1;";
		            try {
						connection = DBConnection.getConnection();
						stmt = connection.prepareStatement(sql);
						stmt.setString(1, student.getEmail());
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
							n.setChecked(0);
							n.setFileName("");
							notes.add(n);
						}
						request.getSession().setAttribute("NotesStudent", notes);
						result = 1;
						redirect =  request.getContextPath() + "/student/ListNote.jsp";
					} catch (SQLException e) {
						e.printStackTrace();
					}	     	
				//FINE
				result = 1;
		        redirect = request.getContextPath() + "/student/ProfileStudent.jsp";  
			} else {
				result = 1;
				error = "Errore visualizzazione profilo";
			}
		}
		if(flag == 6) { //Visualizza singolo appunto
	    	int index = Integer.parseInt(request.getParameter("index"));
	    	System.out.println(index);
			request.getSession().setAttribute("index", index);
			ArrayList<NoteInterface> notes = (ArrayList<NoteInterface>) request.getSession().getAttribute("Notes");
			NoteInterface note = notes.get(index);
			if(note != null) {
				request.getSession().setAttribute("Note", note);
	            ArrayList<ReviewInterface> reviews = new ArrayList<ReviewInterface>();
	            String sql = "SELECT * from review WHERE ID_Note = ?;";
	            try {
					connection = DBConnection.getConnection();
					stmt = connection.prepareStatement(sql);
					stmt.setInt(1, note.getId());
					ResultSet rs = stmt.executeQuery();	
					System.out.println(stmt.toString());
					while(rs.next()){
						ReviewInterface review = new Review();
						review.setComment(rs.getString("Comment"));
						review.setStar(rs.getInt("Stars"));
						review.setAutor(rs.getString("Autor"));
						reviews.add(review);
					}
					System.out.println("Size:" +reviews.size());
					request.getSession().setAttribute("Reviews", reviews);
					result = 1;
			        redirect = request.getContextPath() + "/student/ViewNote.jsp";  
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				result = 0;
				error = "Errore visualizzazione appunto";
			}
		}
		if(flag == 7) { //Scrivi recensione
			System.out.println("Sono nella servlet student flag 7");
	    	int star = Integer.parseInt(request.getParameter("count"));
	    	String review = request.getParameter("review");
	    	int id_note = Integer.parseInt(request.getParameter("id"));
	    	System.out.print(id_note);
	    	String email = userS.getEmail();
	    	System.out.println(email);
	    	String autor = userS.getName()+" "+userS.getSurname();
		    String sql = "INSERT INTO Review (Comment, Stars, Email_User, ID_Note, Autor) VALUES (?, ?, ?, ?, ?)";
		    try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, review);
				stmt.setInt(2, star);
				stmt.setString(3, email);
				stmt.setInt(4, id_note);
				stmt.setString(5, autor);
				if (stmt.executeUpdate() > 0) {
					Review r = new Review();
					r.setComment(review);
					r.setStar(star);
					r.setAutor(autor);
		            ArrayList<ReviewInterface> reviews = (ArrayList<ReviewInterface>) request.getSession().getAttribute("Reviews");
		            reviews.add(r);
		            request.getSession().removeAttribute("Reviews");
		            request.getSession().setAttribute("Reviews", reviews);
	                content = "Recensione effettuata";
	                result = 1;
	                redirect = request.getContextPath() + "/student/ViewNote.jsp";  
	              } else {
	            	  result = 0;
	            	  error = "Errore invio recensione";
	              }
					connection.commit();
			} catch(SQLException e) {
				System.out.print(e);
			}
		}
		if(flag == 8) { //Visualizza profilo (Visualizza gli appunti)
			System.out.println(flag);
            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
            String sql = "SELECT * from note WHERE Email_User = ?;";
            System.out.println(sql);
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, userS.getEmail());
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
					n.setFileName("");
					notes.add(n);
				}
				request.getSession().setAttribute("MyNotes", notes);
				result = 1;
				redirect =  request.getContextPath() + "/student/ProfilePrivateStudent.jsp";
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
