package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Student;
import model.interfaces.UserInterface;
import model.interfaces.UserInterfaceDAO;
import model.DAO.UserDAO;

@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentRegistration() {
        super();
    }

    /**
     * This servlet allows the student to register.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentRegistration chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
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
		UserInterfaceDAO UserDAO = new UserDAO();
		if (UserDAO.saveStudent(user) == true) {
			redirect = request.getContextPath() + "/student/HomeStudent.jsp";
			request.getSession().setAttribute("user", user);
			content = "Registrazione effettuata correttamente.";
			result = 1;
		 } else {
			result = 0;
		    error = "Impossibile effettuare la registrazione.";
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
