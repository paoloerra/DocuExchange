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
import interfaces.UserInterfaceDAO;
import DAO.NoteDAO;
import DAO.UserDAO;

@WebServlet("/AdminCheckRequest")
public class AdminCheckRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public AdminCheckRequest() {
        super();
    }

    /**
     * This servlet allows the admin to verify a student sharing request. 
     * Approved request: the note is published on the platform
     * Request rejected:The request is canceled.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminCheckRequest chiamata");
		String error = ""; 
		String content = "";
		String redirect = "";
		Integer result = 0;

		ArrayList<NoteInterface> requests = (ArrayList<NoteInterface>) request.getSession().getAttribute("requests");
		int index =(Integer) request.getSession().getAttribute("index");
		int outcome = Integer.parseInt(request.getParameter("outcome"));
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("autor");
		NoteInterfaceDAO NoteDAO = new NoteDAO();
		
		if(outcome == 1){ //SE è 1 la richiesta è accettata, l'appunto viene pubblicato e vengono aggiunti 3 download all'utente
			NoteInterface req = requests.get(index);
			String email_student = req.getStudentEmail();
			System.out.println(email_student);
			System.out.println(id);
			UserInterfaceDAO UserDAO = new UserDAO();
			if(NoteDAO.UpdateRequestAccept(id) && UserDAO.UpdateResetLimitDownloadStudent(email_student) == true) {
				requests.remove(index);
				SendEmail.SendAcceptedEmail(email, name);
				result = 1;
				redirect = request.getContextPath() + "/admin/ListRequest.jsp";
			}
			else {
				result = 0;
				error = "Errore la richiesta non è stata accettata";
			}
		}
		else if(outcome == 0){ //SE è 0 la richiesta è rifiutata, la richiesta viene cancellata;
			if(NoteDAO.UpdateRequestRifiuted(id) == true) {
				SendEmail.SendRifiutedEmail(email, name);
				requests.remove(index);
				result = 1;
				redirect = request.getContextPath() + "/admin/ListRequest.jsp";
			}
			else {
				result = 0;
				error = "Errore la richiesta non è stata rifiutata";
			}
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
