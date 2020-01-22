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
import interfaces.UserInterface;
import DAO.NoteDAO;

@WebServlet("/StudentShowMyProfile")
public class StudentShowMyProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentShowMyProfile() {
        super();
    }
    /**
     * This servlet allows the student to view their profile.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentShowMyProfile chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
		ArrayList<NoteInterface> notes = NoteDAO.selectMyNote(userS.getEmail());
		if(notes != null) {
			request.getSession().setAttribute("MyNotes", notes);
			result = 1;
			redirect =  request.getContextPath() + "/student/ProfilePrivateStudent.jsp";	
		}
		else {
			result = 0;
			error = "Error select my profile";
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
