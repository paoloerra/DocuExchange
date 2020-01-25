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

import interfaces.UserInterface;
import interfaces.UserInterfaceDAO;
import DAO.UserDAO;

@WebServlet("/StudentListStudent")
public class StudentListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentListStudent() {
        super();
    }

    /**
     * This servlet allows the student to view the list of students registered on the platform.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletStudentListStudent chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
		UserInterfaceDAO UserDAO = new UserDAO();
	    ArrayList<UserInterface> students = UserDAO.selectStudent(userS.getEmail());
	    if(students != null) {
        	redirect = request.getContextPath() + "/student/ListStudent.jsp";            
        	request.getSession().setAttribute("students", students);
			result = 1;   	
		} else {
			result = 0;
			error = "Error list student";
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
