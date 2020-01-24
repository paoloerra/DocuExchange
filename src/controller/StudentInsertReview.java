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

import interfaces.ReviewInterface;
import interfaces.UserInterface;
import model.Review;
import DAO.ReviewDAO;


@WebServlet("/StudentInsertReview")
public class StudentInsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInsertReview() {
        super();
    }
    
    /**
     * This servlet allows the student to write a review.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentInsertReview chiamata");
		String error = "";
		String content = "";
		String redirect = "";
		Integer result = 0;
		UserInterface userS = (UserInterface) request.getSession().getAttribute("user");
			
		int star = Integer.parseInt(request.getParameter("count"));
    	String comment = request.getParameter("review");
    	int id_note = Integer.parseInt(request.getParameter("id"));
		String autor = userS.getName()+" "+userS.getSurname();
		    	System.out.println(comment.length());
		    	System.out.println(comment);
		if (comment.length() > 255 || comment.length() <1) {
			throw new IllegalArgumentException("Commento troppo lungo");
		}
		ReviewInterface review = new Review(0, userS.getEmail(), id_note , comment, star, autor);
		if (ReviewDAO.saveReview(review) ==  true) {
			ArrayList<ReviewInterface> reviews = (ArrayList<ReviewInterface>) request.getSession().getAttribute("Reviews");
		    reviews.add(review);
		    request.getSession().removeAttribute("Reviews");
		    request.getSession().setAttribute("Reviews", reviews);
		    content = "Recensione effettuata";
		    result = 1;
		    redirect = request.getContextPath() + "/student/ViewNote.jsp";  
		} else {
			result = 0;
	    	error = "Errore invio recensione";
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
