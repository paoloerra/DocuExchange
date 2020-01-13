package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfaces.NoteInterface;
import interfaces.UserInterface;
import model.Request;
import model.Student;



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
	    PreparedStatement stmt = null;
		Connection connection  = null;
		
		System.out.println("Servlet admin chiamata");
		int flag = Integer.parseInt(request.getParameter("flag"));
		System.out.println(flag);
		
		if(flag == 1) { //Visualizza lista richieste in ListRequest.jsp
            ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
            System.out.println("ciao");
            String sql = "SELECT * from note WHERE Checked = 0;";
            try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();	
				while(rs.next()){
					NoteInterface req = new Request();
					req.setID(rs.getInt("ID_Note"));
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
		if(flag == 2) { //Visualizza singola richiesta in ViewRequest.jsp
			System.out.println("Sono nel flag 2");
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

			System.out.println(email);
			System.out.println(id);
			System.out.println(outcome);
			String sql = "";
			if(outcome == 1){ //SE è 1 la richiesta è accettata, l'appunto viene pubblicato e vengono aggiunti 3 download all'utente
				sql = "UPDATE note SET Checked = 1 WHERE ID_Note = ?;";
			}
			else if(outcome == 0){ //SE è 0 la richiesta è rifiutata, la richiesta viene cancellata;
				sql = "DELETE FROM note WHERE ID_Note = ?";
			}
			try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, id);
				System.out.println(stmt.toString());
				if(stmt.executeUpdate() == 1) {
					if(outcome == 1){ 
						NoteInterface req = requests.get(index);
						requests.remove(index);
						String email_student = req.getStudentEmail();
						String sql2 = "UPDATE user SET LimitDownload = 3 WHERE Email_User = ?;";
						PreparedStatement stmt2;
						stmt2 = connection.prepareStatement(sql2);
						stmt2.setString(1, email_student);
						System.out.println(stmt2.toString());
						stmt2.executeUpdate();
						SendEmail.SendAcceptedEmail(email, name);
					}
					else if(outcome == 0){ 
						SendEmail.SendRifiutedEmail(email, name);
						requests.remove(index);
					}
					result = 1;
			        redirect = request.getContextPath() + "/admin/ListRequest.jsp"; 
				} else { 
					result = 0;
					error = "Errore verifica richiesta";
				}
				connection.commit();	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		}
		if(flag == 4) { //Cerca richiesta
			System.out.println(flag);
			String autor = request.getParameter("autor");
			System.out.println(autor);
		try {
            String sql = "";
            ArrayList<NoteInterface> requests = new ArrayList<NoteInterface>();
			connection = DBConnection.getConnection();
			if(autor == "") {	//Nessuna ricerca
				System.out.println("aaa");
        		sql = "SELECT * from Note WHERE Checked = 0";
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();	
            }
            else {
            	sql = "SELECT * from Note WHERE Autor = ? AND Checked = 0;";
    			stmt = connection.prepareStatement(sql);
                stmt.setString(1, autor);
            }
			System.out.println(stmt.toString());
			ResultSet rs = stmt.executeQuery();	
			while(rs.next()){
				NoteInterface req = new Request();
				req.setID(rs.getInt("ID_Note"));
				req.setCourse(rs.getString("Course"));
				req.setProfessor(rs.getString("Professor"));
				req.setDescription(rs.getString("Description"));
				req.setStudentEmail(rs.getString("Email_User"));
				req.setAutor(rs.getString("autor"));
				req.setChecked(0);
				requests.add(req);
			}
			request.getSession().setAttribute("requests", requests);
			result = 1;
			redirect =  request.getContextPath() + "/admin/ListRequest.jsp";
		} catch (SQLException e) {
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
