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

import interfaces.NoteInterface;
import DAO.NoteDAO;


@WebServlet("/StudentSearchNote")
public class StudentSearchNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSearchNote() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentSearchNote chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		
		String course = request.getParameter("course");
		String professor = request.getParameter("professor");
		
	    ArrayList<NoteInterface> Searchnotes = new ArrayList<NoteInterface>();
	    if(course == "" && professor == "") {
	    	Searchnotes = NoteDAO.selectNote();
	    }
	    else {
	    	Searchnotes = NoteDAO.SearchNote(course, professor);
	    }
	    if(Searchnotes != null) {
	    	request.getSession().removeAttribute("Notes");
			request.getSession().setAttribute("Notes", Searchnotes);
			result = 1;
	        redirect = request.getContextPath() + "/student/ListNote.jsp";
	        content = "Ricerca eseguita";	
	    }
	    else {
	    	result = 0;
	    	error = "Error search note";
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
