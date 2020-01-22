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



@WebServlet("/StudentShowNote")
public class StudentShowNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentShowNote() {
        super();
    }
    /**
     * This servlet allows the student to view a single note.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentShowNote chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		
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
