package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfaces.NoteInterface;
import interfaces.UserInterface;
import DAO.NoteDAO;
import model.Request;

@WebServlet("/StudentSendRequest")
public class StudentSendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSendRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentSendRequest chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
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
