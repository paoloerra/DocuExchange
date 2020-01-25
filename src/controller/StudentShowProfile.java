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
import interfaces.NoteInterfaceDAO;
import interfaces.ReviewInterface;
import interfaces.UserInterface;
import DAO.NoteDAO;
import model.Request;
import model.Review;
import DAO.ReviewDAO;
import model.Student;
import DAO.UserDAO;



@WebServlet("/StudentShowProfile")
public class StudentShowProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentShowProfile() {
        super();
    }
    /**
     * This servlet allows the student to view the profile of another student.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentShowProfile chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
		ArrayList<UserInterface> students = (ArrayList<UserInterface>) request.getSession().getAttribute("students");
		int index = Integer.parseInt(request.getParameter("index"));
		UserInterface student = students.get(index);
		if(student != null) {
			NoteInterfaceDAO NoteDAO = new NoteDAO();
			request.getSession().setAttribute("profile", student);
			//Prelevo i suoi appunti pubblicati
			ArrayList<NoteInterface> notes = NoteDAO.selectNoteStudent(student.getEmail());
			request.getSession().setAttribute("NotesStudent", notes);
			result = 1;
			redirect = request.getContextPath() + "/student/ProfileStudent.jsp";  
		} else {
			result = 1;
			error = "Errore show profile";
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
