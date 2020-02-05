<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,model.interfaces.UserInterface,model.interfaces.NoteInterface,model.interfaces.ReviewInterface, java.util.LinkedList, java.util.Collection, java.util.*, model.bean.Review"%>
<%
	String pageName = "ViewNote.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("profile");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	
	NoteInterface note = (NoteInterface) session.getAttribute("Note");
	int id_note = note.getId();
	Collection<?> Reviews= (Collection<?>) request.getSession().getAttribute("Reviews");	
	String error = (String) request.getAttribute("error");
	System.out.println(error);
	String msg = (String) request.getAttribute("msg");
	System.out.println(error);
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Appunto</title>
		<jsp:include page="/partials/includes.jsp"/>
		<script src="<%= request.getContextPath() %>/js/pages/scripts_review.js"></script>
		<!-- PER LE STELLINE -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
	</head>
	<body>
		<jsp:include page="/partials/navbar.jsp"/>
		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
					<!-- REQUEST -->
					<div class="wrapper">
						<h1>APPUNTO</h1>
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Corso</div>
									<input type="text" value="<%=note.getCourse()%>"readonly>
									<input id="id" type="text" value="<%=id_note%>" hidden>								
								</div>
								<div class="inner-form">
									<div class="label">Professore</div>
									<input type="text" value="<%=note.getProfessor()%>"readonly>
								</div>			
								<div class="inner-form">
									<div class="label">Autore</div>
									<input type="text" value="<%=note.getAutor()%>"readonly>
								</div>		
							</div>
							<div class="bottom-form">
								<div class="inner-form">
									<textarea readonly><%=note.getDescription()%></textarea>
								</div>
							</div>
							<%if(error != null) {%>
								<p style="color:red"><%=error %></p>
							<%}%>
							<a style="color:white" href="<%=request.getContextPath() %>/DownloaderServlet?flag=2&id=<%=id_note%>"'><div class="btn">Scarica PDF</div></a>
							<div class="bottom-form"></div>
							<%if(Reviews != null && Reviews.size() > 0) {
								Iterator<?> it = Reviews.iterator();%>
								<h4>RECENSIONI</h4>
								<div style="width: 920px; height:400px; overflow-y: scroll;">
									<%int i = 0;
									int som = 0;
									while(i < 3 && it.hasNext()){
										ReviewInterface review = (ReviewInterface) it.next();%>
										<div class="card">
							  				<div class="card-body">
											    <h5 class="card-title"><%=review.getAutor()%></h5>
											    <p class="card-text"><%=review.getComment()%>.</p>
											    <p class="card-text">
							    				<%int star = review.getStar();
							    				som = star + som;
							    				int j = 0;
							    				while(j < star){
							    					j++;%>
							    				<img src="<%= request.getContextPath() %>/images/star.png">
							    				<%}%>
							    				</p>
							  				</div>
										</div>
									<%} 
					    			int med = som / Reviews.size();
					    			%>
				    			</div>
				    			<div class="bottom-form"></div>
									<h4>MEDIA RECENSIONI</h4>
									<%i = 0;
									while(i < med) {
										i++;%>
										<img src="<%= request.getContextPath() %>/images/starfull.png">
				    				<%}
				    				while(i < 5) {
				    					i++;%>
				    					<img src="<%= request.getContextPath() %>/images/starblack.png">
				    				<% }
				    				
				    		}%>
							<div class="bottom-form"></div>							
								<h4>FAI UNA RECENSIONE</h4>
								<div class="bottom-form">
									<div class="inner-form">
										<textarea id="review" placeholder="Scrivi qui la tua recensione"></textarea>
									</div>
								</div>		
								<style>
								.checked {
		   					 		color: rgb(237, 138, 25)
								}
								</style>
								<span  onmouseover="scripts_review:starmark(this)" onclick="starmark(this)" id="1one" style="font-size:40px;cursor:pointer;"  class="fa fa-star checked"></span>
								<span onmouseover="scripts_review:starmark(this)" onclick="starmark(this)" id="2one"  style="font-size:40px;cursor:pointer;" class="fa fa-star "></span>
								<span onmouseover="scripts_review:starmark(this)" onclick="starmark(this)" id="3one"  style="font-size:40px;cursor:pointer;" class="fa fa-star "></span>
								<span onmouseover="scripts_review:starmark(this)" onclick="starmark(this)" id="4one"  style="font-size:40px;cursor:pointer;" class="fa fa-star"></span>
								<span onmouseover="scripts_review:starmark(this)" onclick="starmark(this)" id="5one"  style="font-size:40px;cursor:pointer;" class="fa fa-star"></span>
								<br/>
								<div class="bottom-form">
									<div class="inner-form">
										<button id="btnreview" type="submit" class="btn">Recensisci</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		<!-- FOOTER -->
		<jsp:include page="../partials/footer.jsp"/>
	</body>
</html>