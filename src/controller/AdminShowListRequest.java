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

@WebServlet("/AdminShowListRequest")
public class AdminShowListRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminShowListRequest() {
        super();
    }
    
    /**
     * This servlet allows the admin to view the list of requests.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminShowListRequest chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		NoteInterfaceDAO NoteDAO = new NoteDAO();
		
        ArrayList<NoteInterface> requests = NoteDAO.selectRequest();
        if(requests != null) {
        	request.getSession().setAttribute("requests", requests);
            result = 1;
            redirect =  request.getContextPath() + "/admin/ListRequest.jsp";	     		
        }
        else {
        	result = 0;
        	error = "Error show List Request";
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
