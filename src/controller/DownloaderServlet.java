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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("Servlet File");
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		if(flag == 1) {	//Download
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			ResultSet rs = null;
			PreparedStatement stmt = null;
			Connection connection  = null;
			InputStream input = null;
			String sql = "SELECT * from note WHERE ID_Note = ?;";
	        try {
				connection = DBConnection.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
				System.out.println(stmt.toString());
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
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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