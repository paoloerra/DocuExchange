package controller;

import java.io.Closeable;
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
import DAO.UserDAO;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		if(flag == 1) { //Visualizza lista richieste in ListRequest.jsp
            ArrayList<NoteInterface> requests = NoteDAO.selectRequest();
            request.getSession().setAttribute("requests", requests);
			result = 1;
			redirect =  request.getContextPath() + "/admin/ListRequest.jsp";	     	
		}
	
		if(flag == 2) { //Visualizza singola richiesta in ViewRequest.jsp
			int index = Integer.parseInt(request.getParameter("index"));
			request.getSession().setAttribute("index", index);
			ArrayList<NoteInterface> requests = (ArrayList<NoteInterface>) request.getSession().getAttribute("requests");
			NoteInterface req = requests.get(index);
			if(req != null) {
				request.getSession().setAttribute("req", req);
				result = 1;
		        redirect = request.getContextPath() + "/admin/ViewRequest.jsp";  
			} else {
				result = 1;
				error = "Errore visualizzazione profilo";
			}
		}
				
		if(flag == 3) { //Verifica richiesta
			ArrayList<NoteInterface> requests = (ArrayList<NoteInterface>) request.getSession().getAttribute("requests");
			int index =(Integer) request.getSession().getAttribute("index");
			int outcome = Integer.parseInt(request.getParameter("outcome"));
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String name = request.getParameter("autor");
			if(outcome == 1){ //SE è 1 la richiesta è accettata, l'appunto viene pubblicato e vengono aggiunti 3 download all'utente
				if(NoteDAO.UpdateRequestAccept(id) == false) {
					result = 0;
					error = "Errore la richiesta non è stata accettata";
				}
				NoteInterface req = requests.get(index);
				requests.remove(index);
				String email_student = req.getStudentEmail();
				if(UserDAO.UpdateResetLimitDownloadStudent(email_student) == false) {
					result = 0;
					error = "Errore il limite download non è stato resettato";
				}
				SendEmail.SendAcceptedEmail(email, name);
			}
			else if(outcome == 0){ //SE è 0 la richiesta è rifiutata, la richiesta viene cancellata;
				if(NoteDAO.UpdateRequestRifiuted(id) == false) {
					result = 0;
					error = "Errore la richiesta non è stata rifiutata";
				}
				SendEmail.SendRifiutedEmail(email, name);
				requests.remove(index);
			}
				result = 1;
		        redirect = request.getContextPath() + "/admin/ListRequest.jsp"; 
		}
	
					
		if(flag == 4) { //Cerca richiesta
			String autor = request.getParameter("autor");
			String sql = "";
	        ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	        if (autor.length() == 2 || autor.length() == 1  || autor.length() > 20 || autor.matches(".*\\d+.*")) {
	        	throw new IllegalArgumentException("Formato non corretto");
		    }
			if(autor == "") {	//Nessuna ricerca, vengono mostrate tutte le richieste.
				requests = NoteDAO.selectRequest();
		    }
            else {
            	requests = NoteDAO.selectSearchRequest(autor);
		    }
			request.getSession().setAttribute("requests", requests);
			result = 1;
			redirect =  request.getContextPath() + "/admin/ListRequest.jsp";	     	
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
	
	private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }

}
