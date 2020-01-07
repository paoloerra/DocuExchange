package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import interfacce.UserInterface;
import model.Note;
import model.Studente;



@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
	    PreparedStatement stmt = null;
		Connection connection  = null;

		int flag = Integer.parseInt(request.getParameter("flag"));
		if(flag == 1) { //Visualizza richieste
            ArrayList<Note> requests = new ArrayList<Note>();
            String sql = "SELECT * from note WHERE Checked = 0;";
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					Note req = new Note();	
					req.setIdNote(rs.getInt("ID_Note"));
					req.setCourse(rs.getString("Course"));
					req.setProfessor(rs.getString("Professor"));
					req.setDescription(rs.getString("Description"));
					req.setStudentEmail(rs.getString("Email_User"));
					req.setAutor(rs.getString("autor"));
					req.setChecked(0);
					req.setFileName("");
					requests.add(req);
				}
				request.getSession().setAttribute("requests", requests);
				result = 1;
				redirect =  request.getContextPath() + "/admin/ListRequest.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}	     	
		}
		if(flag == 2) { //Visualizza singola richiesta
			int index = Integer.parseInt(request.getParameter("index"));
			request.getSession().setAttribute("index", index);
			ArrayList<Note> requests = (ArrayList<Note>) request.getSession().getAttribute("requests");
			Note req = requests.get(index);
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
			ArrayList<Note> requests = (ArrayList<Note>) request.getSession().getAttribute("requests");
			int index =(Integer) request.getSession().getAttribute("index");
			int outcome = Integer.parseInt(request.getParameter("outcome"));
			String id = request.getParameter("id");
			System.out.println(id);
			System.out.println(outcome);
			String sql = "";
			if(outcome == 1){ 
				sql = "UPDATE note SET checked = 1 WHERE ID_Note = ?;";
				requests.remove(index);
			}
			else if(outcome == 0){ 
				sql = "DELETE FROM note WHERE ID_Note = ?";
				requests.remove(index);
			}
			try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, id);
				System.out.println(stmt.toString());
				if(stmt.executeUpdate() == 1) {
					result = 1;
			        redirect = request.getContextPath() + "/admin/ListRequest.jsp";  
				}
				else {
					result = 0;
					error = "Richiesta non verificata";
				}
				connection.commit();	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
	    

}
