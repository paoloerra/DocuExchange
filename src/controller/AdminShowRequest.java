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

@WebServlet("/AdminShowRequest")
public class AdminShowRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminShowRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminShowRequest chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		
		int index = Integer.parseInt(request.getParameter("index"));
		request.getSession().setAttribute("index", index);
		ArrayList<NoteInterface> requests = (ArrayList<NoteInterface>) request.getSession().getAttribute("requests");
		NoteInterface req = requests.get(index);
		if(req != null) {
			request.getSession().setAttribute("req", req);
			result = 1;
		    redirect = request.getContextPath() + "/admin/ViewRequest.jsp";  
		} else {
			result = 0;
			error = "Errore visualizzazione profilo";
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
