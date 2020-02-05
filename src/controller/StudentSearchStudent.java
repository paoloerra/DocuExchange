package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.DAO.UserDAO;
import model.interfaces.UserInterface;
import model.interfaces.UserInterfaceDAO;



@WebServlet("/StudentSearchStudent")
public class StudentSearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSearchStudent() {
        super();
    }

    /**
     * This servlet allows the student to search for other students by their first and last name.
     * Accepted parameters:
     * Name and surname
     * Example: Paolo Erra
     * 
     * First name
     * Example: Paolo
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentSearchStudent chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		UserInterfaceDAO UserDAO = new UserDAO();
		
		String student = request.getParameter("student");
	    ArrayList<UserInterface> Searchstudent = new ArrayList<UserInterface>();
		
		if(student == "") {	//Nessuna ricerca, visualizza tutti gli studenti
			Searchstudent = UserDAO.selectStudent(userS.getEmail());
	    }else if (student.length() <3 || student.length() > 20  || student.matches(".*\\d+.*")) {
			throw new IllegalArgumentException("Formato non corretto");
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
		if(Searchstudent != null) {
			request.getSession().removeAttribute("students");
			request.getSession().setAttribute("students", Searchstudent);
			result = 1;
		    redirect = request.getContextPath() + "/student/ListStudent.jsp";
	        content = "Ricerca eseguita";		
		}
		else {
			result = 0;
			error = "Error search student";
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
