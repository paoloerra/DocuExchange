<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession, interfacce.UserInterface, model.Note, java.util.LinkedList, java.util.Collection, java.util.*, model.Review"%>
<%
	String pageName = "ViewNote.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("profile");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	
	Note note = (Note) session.getAttribute("Note");
	int id_note = note.getIdNote();
	Collection<?> Reviews = (Collection<?>) request.getSession().getAttribute("Reviews");
	System.out.println("Sono nella jsp"+ Reviews.size());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Appunto</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/toastr.min.css">
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="../css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	
		<script src="../js/pages/scripts_review.js"></script>
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/toastr.min.js"></script>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>



	<div id="fh5co-page">
		<div id="fh5co-wrap">

			<div id="fh5co-main">

			<!-- REQUEST -->
			<div class="wrapper">
			<h1>APPUNTO</h1>

			<form>
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


						<button type="submit" class="btn">Scarica PDF</button>
						
						<h4>VALUTATO</h4>
						<img src="../images/starfull.png"><img src="../images/starfull.png"><img src="../images/starfull.png"><img src="../images/starfull.png">
						
						<div class="bottom-form"></div>
						
						
						<%
						if(Reviews != null && Reviews.size() > 0) {
						Iterator<?> it = Reviews.iterator();
						%>
						<h4>RECENSIONI</h4>
						<div style="width: 920px; height:400px; overflow-y: scroll;">
						<%
						int i = 0;
						while(i < 3 && it.hasNext()){
							Review review = (Review) it.next();
						%>
						<div class="card">
						  <div class="card-body">
						    <h5 class="card-title"><%=review.getAutor()%></h5>
						    <p class="card-text"><%=review.getComment()%>.</p>
						    <p class="card-text">
						    	<%int star = review.getStar();
						    	int j = 0;
						    	while(j < star){
						    		j++;
						    	%>
						    	<img src="../images/star.png">
						    	<% }%>
						    </p>
						  </div>
						</div>
						<% } }%>
						</div>
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
			</form>
		</div>

		</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>