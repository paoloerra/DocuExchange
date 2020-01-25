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
import interfaces.NoteInterfaceDAO;
import DAO.NoteDAO;


@WebServlet("/StudentListNote")
public class StudentListNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentListNote() {
        super();
    }
    
    /**
     * This servlet allows the student to view the list of published notes.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletStudentListNote chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		NoteInterfaceDAO NoteDAO = new NoteDAO();
		
	    ArrayList<NoteInterface> notes = NoteDAO.selectNote();
	    if(notes != null) {
	    	request.getSession().setAttribute("Notes", notes);
			result = 1;
			redirect =  request.getContextPath() + "/student/ListNote.jsp";	    	
		} else {
			result = 0;
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
