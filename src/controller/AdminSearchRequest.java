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

import model.DAO.NoteDAO;
import model.interfaces.NoteInterface;
import model.interfaces.NoteInterfaceDAO;

@WebServlet("/AdminSearchRequest")
public class AdminSearchRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public AdminSearchRequest() {
        super();
    }

    /**
     * This servlet allows the admin to search for requests through the author of the request.
     * accepted parameter: name and surname
     * example: Paolo Erra
     * 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminSearchRequest chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		NoteInterfaceDAO NoteDAO = new NoteDAO();
		
		String autor = request.getParameter("autor");
	    ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
	    if (autor.length() == 2 || autor.length() == 1  || autor.length() > 20 || autor.matches(".*\\d+.*")) {
	    	throw new IllegalArgumentException("Formato non corretto");
		}
	    if(autor == "") {	//Nessuna ricerca, vengono mostrate tutte le richieste.
			requests = NoteDAO.selectRequest();
		}
        else {
        	requests = NoteDAO.selectSearchRequest(autor);
        	if(requests != null) {
        		request.getSession().setAttribute("requests", requests);
    			result = 1;
    			redirect =  request.getContextPath() + "/admin/ListRequest.jsp";
        	}
        	else {
        		result = 0;
        		error = "Error search request";
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
