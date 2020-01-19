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
import model.Student;



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
		int flag = Integer.parseInt(request.getParameter("flag"));
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		Connection connection  = null;
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				if(flag == 1) { //Registrazione
			        UserInterface user = null;
			        int userType = 0;
					String nome = request.getParameter("nome");
					if (nome.length() == 0 || nome.length() > 20 || nome.length() < 2 || nome.matches(".*\\d+.*")) {
						throw new IllegalArgumentException("Formato non corretto");
				    }
					String cognome = request.getParameter("cognome");
					if (cognome.length() == 0 || cognome.length() > 20 || cognome.length() < 2 || cognome.matches(".*\\d+.*")) {
						throw new IllegalArgumentException("Formato non corretto");
				    }
					char sesso = request.getParameter("sesso").charAt(0);
				    if (sesso != 'M' && sesso != 'F') {
				    	throw new IllegalArgumentException("Valore non corretto");
				    }			   
					String email = request.getParameter("email");
					String prefix = "";
				    if (email.length() > 0) {
				    	prefix = email.substring(0, email.indexOf("@"));
				    }
				    if (email.length() == 0 || !email.endsWith("@studenti.unisa.it") || prefix.length() < 3 || prefix.indexOf(".") == -1) {
				    	throw new IllegalArgumentException("Formato non corretto");
				    }  
					String password = request.getParameter("password");
					if (password.length() < 8 || password.matches(".*\\W+.*")) {//aggiunto 
						throw new IllegalArgumentException("Formato non corretto");
				    }
					String sql = "INSERT INTO User (Email_User, Name, Surname, Password, Sex, type, LimitDownload) VALUES (?, ?, ?, ?, ?, ?, '3')";
					stmt = connection.prepareStatement(sql);
					stmt.setString(1, email);
					stmt.setString(2, nome);
					stmt.setString(3, cognome);
					stmt.setString(4, password);
					stmt.setString(5, String.valueOf(sesso));
					stmt.setInt(6, userType);
					if (stmt.executeUpdate() > 0) {
						redirect = request.getContextPath() + "/student/HomeStudent.jsp";
						user = new Student(email, nome, cognome, sesso, password, userType, 3);
			            request.getSession().setAttribute("user", user);
			            content = "Registrazione effettuata correttamente.";
			            result = 1;
			         } else {
			        	 result = 0;
			           	 error = "Impossibile effettuare la registrazione.";
			              }
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
			}
			if(flag == 3) { //Visualizza lista appunti
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
	            String sql = "SELECT * from note WHERE Checked = 1;";
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
			}
			if(flag == 4) { //Lista studenti
	            redirect = request.getContextPath() + "/student/ListStudent.jsp";            
	            ArrayList<UserInterface> students = new ArrayList<UserInterface>();
	            String emailUser = userS.getEmail();
	            System.out.println(emailUser);
	            String sql = "SELECT * from user WHERE Type = 0 AND email_user != ?;";
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, emailUser);
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
				request.getSession().setAttribute("students", students);
				result = 1;
				content = "ok";
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
			        stmt = connection.prepareStatement(sql);
			        stmt.setString(1, student.getEmail());
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
				    redirect = request.getContextPath() + "/student/ProfileStudent.jsp";  
				} else {
					result = 1;
					error = "Errore visualizzazione profilo";
				}
			}
			if(flag == 6) { //Visualizza singolo appunto
		    	int index = Integer.parseInt(request.getParameter("index"));
				request.getSession().setAttribute("index", index);
				ArrayList<NoteInterface> notes = (ArrayList<NoteInterface>) request.getSession().getAttribute("Notes");
				NoteInterface note = notes.get(index);
				if(note != null) {
					request.getSession().setAttribute("Note", note);
		            ArrayList<ReviewInterface> reviews = new ArrayList<ReviewInterface>();
		            String sql = "SELECT * from review WHERE ID_Note = ?;";
					connection = DBConnection.getConnection();
					stmt = connection.prepareStatement(sql);
					stmt.setInt(1, note.getId());
					ResultSet rs = stmt.executeQuery();	
					while(rs.next()){
						ReviewInterface review = new Review();
						review.setComment(rs.getString("Comment"));
						review.setStar(rs.getInt("Stars"));
						review.setAutor(rs.getString("Autor"));
						reviews.add(review);
					}
					request.getSession().setAttribute("Reviews", reviews);
					result = 1;
			        redirect = request.getContextPath() + "/student/ViewNote.jsp";  
				} else {
					result = 0;
					error = "Errore visualizzazione appunto";
				}
			}
			if(flag == 7) { //Scrivi recensione
		    	int star = Integer.parseInt(request.getParameter("count"));
		    	String review = request.getParameter("review");
		    	int id_note = Integer.parseInt(request.getParameter("id"));
		    	String email = userS.getEmail();
		    	String autor = userS.getName()+" "+userS.getSurname();
			    String sql = "INSERT INTO Review (Comment, Stars, Email_User, ID_Note, Autor) VALUES (?, ?, ?, ?, ?)";
			    if (review.length() > 255 || review.length() <1) {
					throw new IllegalArgumentException("Commento troppo lungo");
			    }
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
			}
			if(flag == 8) { //Visualizza profilo (Visualizza gli appunti)
	            ArrayList<NoteInterface> notes = new ArrayList<NoteInterface>();
	            String sql = "SELECT * from note WHERE Email_User = ?;";
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, userS.getEmail());
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
			}
			if(flag == 9) { //Cerca appunti
				String course = request.getParameter("course");
				String professor = request.getParameter("professor");
	            ArrayList<NoteInterface> Searchnotes = new ArrayList<NoteInterface>();
	            String sql = "";
	            if(course == "" && professor == "") {
	            	sql = "SELECT * from note";
	    			stmt = connection.prepareStatement(sql);
	            }
	            else {
	            	sql = "SELECT * from note WHERE Course = ? AND Professor = ?;";
	    			stmt = connection.prepareStatement(sql);
	                stmt.setString(1, course);
	                stmt.setString(2, professor);
	            }
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
					Searchnotes.add(n);
				}
				request.getSession().removeAttribute("Notes");
				request.getSession().setAttribute("Notes", Searchnotes);
				result = 1;
                redirect = request.getContextPath() + "/student/ListNote.jsp";
                content = "Ricerca eseguita";		
			}
			if(flag == 10) { //Cerca studenti
				String student = request.getParameter("student");
	            String sql = "";
	            ArrayList<UserInterface> Searchstudent = new ArrayList<UserInterface>();
				if (student.length() == 2 || student.length() == 1  || student.length() > 20  || student.matches(".*\\d+.*")) {
					throw new IllegalArgumentException("Formato non corretto");
			    }
				if(student == "") {	//Nessuna ricerca
	        		sql = "SELECT * from user WHERE Type = 0";
					stmt = connection.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();	
	            }
				else if(student.contains(" ")){ //Stringa formata da Nome e Cognome
					String NameSurname[] = student.split(" ");
					String name = NameSurname[0];
					String surname = NameSurname[1];
	            	sql = "SELECT * from user WHERE Name = ? AND Surname = ? AND Type = 0;";
	    			stmt = connection.prepareStatement(sql);
	                stmt.setString(1, name);
	                stmt.setString(2, surname);
				}
	            else {
	            	sql = "SELECT * from user WHERE Name = ? AND Type = 0;";
	    			stmt = connection.prepareStatement(sql);
	                stmt.setString(1, student);
	            }
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					UserInterface s = new Student();	
					s.setName(rs.getString("Name"));
						s.setSurname(rs.getString("Surname"));
						s.setEmail(rs.getString("Email_User"));
						s.setSex(rs.getString("sex").charAt(0));
						Searchstudent.add(s);
					}
					request.getSession().removeAttribute("students");
					request.getSession().setAttribute("students", Searchstudent);
					result = 1;
	                redirect = request.getContextPath() + "/student/ListStudent.jsp";
	                content = "Ricerca eseguita";		
			}
			connection.commit();
		} catch (SQLException exception) {
			exception.printStackTrace();
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
	    

}
