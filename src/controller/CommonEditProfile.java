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


@WebServlet("/CommonEditProfile")
public class CommonEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommonEditProfile() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("CommonEditProfile chiamata");
    	String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		
	    UserInterface u = (UserInterface) request.getSession().getAttribute("user");
		int type = u.getUserType();
		String name = request.getParameter("name");
		if (name.length() == 0 || name.length() > 20 || name.length() < 2 || name.matches(".*\\d+.*")) {
			error = "nome non corretto";
			result = 0;
			throw new IllegalArgumentException("Formato non corretto");
		}
		u.setName(name);
			
		String surname = request.getParameter("surname");
		if (surname.length() == 0 || surname.length() > 20 || surname.length() < 2 || surname.matches(".*\\d+.*")) {
			throw new IllegalArgumentException("Formato non corretto");
		}
		u.setSurname(surname);
				
		String password = request.getParameter("password");
		if (password.length() < 8 || password.matches(".*\\W+.*")) {
			throw new IllegalArgumentException("Formato non corretto");
		}
		u.setPassword(password);
				
		char sex = request.getParameter("sex").charAt(0);
		if (sex != 'M' && sex != 'F') {
			throw new IllegalArgumentException("Valore non corretto");
		}
		u.setSex(sex);		
				
		if(UserDAO.UpdateProfileUser(u) == true) {
			result = 1;
			content = "Modifica effettuata";
		}
		else {
			result = 0;
			error = "Modifica non effettuata";				
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
