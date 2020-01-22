package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfaces.UserInterface;
import DAO.UserDAO;


@WebServlet("/CommonLogin")
public class CommonLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommonLogin() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Servlet CommonLogin chiamata");
    	String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserInterface user = UserDAO.SelectLoginUser(email, password);
		if(user == null) {
		    error = "Login fallito.";
		    result = 0;
		 }
		 if(user.getUserType() == 0) {
		    redirect = request.getContextPath() + "/student/HomeStudent.jsp";
		    request.getSession().setAttribute("user", user);
            content = "Login corretto.";
            result = 1;
		  }
		  else if(user.getUserType() == 1) {
			  redirect = request.getContextPath() + "/admin/HomeAdmin.jsp";
			  request.getSession().setAttribute("user", user);
		      content = "Login corretto.";
              result = 1;
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
