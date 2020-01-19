package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.UserInterface;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/DownloaderServlet")
public class DownloaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

       
  
    public DownloaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection connection  = null;
		InputStream input = null;
		try {
			connection = DBConnection.getConnection();
			if(connection != null) {
				if(flag == 1) {	//Download richiesta Admin
					int id = Integer.parseInt(request.getParameter("id"));
					System.out.println(id);
					String sql = "SELECT * from note WHERE ID_Note = ?;";
					stmt = connection.prepareStatement(sql);
					stmt.setInt(1, id);
					rs = stmt.executeQuery();
					System.out.println("Query eseguita");
					response.reset();
			        response.setBufferSize(DEFAULT_BUFFER_SIZE);
			        response.setContentType("application-pdf");
			        response.setHeader("Content-disposition","attachment; filename=Appunto.pdf");
			        while(rs.next()){
			        	input = rs.getBinaryStream("FilePDF");
						 BufferedInputStream in = null;
					     BufferedOutputStream out = null;
					     try {
					    	 in = new BufferedInputStream(input, DEFAULT_BUFFER_SIZE);
					    	 out = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
					    	 byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
					    	 int length;
					    	 while ((length = input.read(buffer)) > 0) {
					    		 out.write(buffer, 0, length);
						      }
						   } finally {
							   close(out);
						       close(in);
						   }
					}
				}
				if(flag == 2) {	//Download Appunto studente
					UserInterface user = (UserInterface) request.getSession().getAttribute("user");
					System.out.println("Limite download utente: "+user.getLimitDownload());
					if(user.getLimitDownload() > 0) {	//Controllo il limite download è > 0 lo decremento e scarico l'appunto, altrimenti non lo scarico;
						String sql = "UPDATE user SET LimitDownload= ? WHERE email_user = ?";
						stmt = connection.prepareStatement(sql);
						stmt.setInt(1, user.getLimitDownload() - 1);
						stmt.setString(2, user.getEmail());
						stmt.executeUpdate();
							
						user.setLimitDownload(user.getLimitDownload() - 1);
						request.getSession().setAttribute("user", user);
							
						int id = Integer.parseInt(request.getParameter("id"));
						sql = "SELECT * from note WHERE ID_Note = ?;";
						stmt = connection.prepareStatement(sql);
						stmt.setInt(1, id);
						rs = stmt.executeQuery();		
							
						response.reset();
						response.setBufferSize(DEFAULT_BUFFER_SIZE);
						response.setContentType("application-pdf");
						response.setHeader("Content-disposition","attachment; filename=Appunto.pdf");
						while(rs.next()){
							input = rs.getBinaryStream("FilePDF");
							BufferedInputStream in = null;
							BufferedOutputStream out = null;
							try {
								in = new BufferedInputStream(input, DEFAULT_BUFFER_SIZE);
								out = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
								byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
								int length;
								while ((length = input.read(buffer)) > 0) {
									out.write(buffer, 0, length);
								}
							} finally {
								close(out);
								close(in);	
							}
						}  
						} else {
							String error = "Il tuo limite di download è insufficiente, condividi un tuo appunto per scaricare 3 appunti.";
							request.setAttribute("error", error);
						}
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/student/ViewNote.jsp");
					dispatcher.forward(request, response);
				}
			}
			connection.commit();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
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
