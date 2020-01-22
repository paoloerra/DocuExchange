package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfaces.NoteInterface;
import interfaces.ReviewInterface;
import interfaces.UserInterface;
import DAO.NoteDAO;
import model.Request;
import model.Review;
import DAO.ReviewDAO;
import model.Student;
import DAO.UserDAO;



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
		int flag = Integer.parseInt(request.getParameter("flag"));
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
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
			user = new Student(email, nome, cognome, sesso, password, userType, 3);
			if (UserDAO.saveStudent(user) == true) {
				redirect = request.getContextPath() + "/student/HomeStudent.jsp";
				request.getSession().setAttribute("user", user);
				content = "Registrazione effettuata correttamente.";
				result = 1;
		     } else {
		    	result = 0;
		    	error = "Impossibile effettuare la registrazione.";
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
		    FileInputStream file = new FileInputStream(theFile);
		    String autor = student.getName() +" "+student.getSurname();
		    NoteInterface req = new Request(0, email, course, professor, description, file, autor, 0);
		    if (NoteDAO.saveRequest(req) == true) {
				SendEmail.SendRequestEmail(email, userS.getName(), course, professor, description);
		        content = "Invio richiesta effettuato.";
                result = 1;
            } else {
		    	result = 0;
		        error = "Errore invio richiesta";
			    }
			}
			if(flag == 3) { //Visualizza lista appunti
	            ArrayList<NoteInterface> notes = NoteDAO.selectNote();
	            if(notes != null) {
	            	request.getSession().setAttribute("Notes", notes);
					result = 1;
					redirect =  request.getContextPath() + "/student/ListNote.jsp";	    	
	            }
			}
			
			if(flag == 4) { //Lista studenti
	            ArrayList<UserInterface> students = UserDAO.selectStudent(userS.getEmail());
	            if(students != null) {
	            	redirect = request.getContextPath() + "/student/ListStudent.jsp";            
					request.getSession().setAttribute("students", students);
					result = 1;   	
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
					ArrayList<NoteInterface> notes = NoteDAO.selectNoteStudent(student.getEmail());
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
		            ArrayList<ReviewInterface> reviews = ReviewDAO.selectReview(note.getId());
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
		    	String comment = request.getParameter("review");
		    	int id_note = Integer.parseInt(request.getParameter("id"));
		    	String autor = userS.getName()+" "+userS.getSurname();
		    	
			    if (comment.length() > 255 || comment.length() <1) {
					throw new IllegalArgumentException("Commento troppo lungo");
			    }
		    	ReviewInterface review = new Review(0, userS.getEmail(), id_note , comment, star, autor);
				if (ReviewDAO.saveReview(review) ==  true) {
		            ArrayList<ReviewInterface> reviews = (ArrayList<ReviewInterface>) request.getSession().getAttribute("Reviews");
		            reviews.add(review);
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
	            ArrayList<NoteInterface> notes = NoteDAO.selectMyNote(userS.getEmail());
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
	            	Searchnotes = NoteDAO.selectNote();
	            }
	            else {
	            	Searchnotes = NoteDAO.SearchNote(course, professor);
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
				if(student == "") {	//Nessuna ricerca, visualizza tutti gli studenti
					Searchstudent = UserDAO.selectStudent(userS.getEmail());
	            }
				else if(student.contains(" ")){ //Stringa formata da Nome e Cognome
					String NameSurname[] = student.split(" ");
					String name = NameSurname[0];
					String surname = NameSurname[1];
	            	Searchstudent = UserDAO.selectSearchForNameAndSurnameStudent(name, surname, userS.getEmail());
				}
	            else {
	    			Searchstudent = UserDAO.selectSearchForNameStudent(student, userS.getEmail());
	            }
				request.getSession().removeAttribute("students");
				request.getSession().setAttribute("students", Searchstudent);
				result = 1;
	            redirect = request.getContextPath() + "/student/ListStudent.jsp";
                content = "Ricerca eseguita";		
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
