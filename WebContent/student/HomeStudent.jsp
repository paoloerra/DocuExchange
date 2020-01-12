<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface"%>
    
<%
	String pageName = "HomeStudent.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Home: Studente</title>
		
		<jsp:include page="/partials/includes.jsp"/>
		
		<script src="../js/pages/scripts_listStudent.js"></script>
		<script src="../js/pages/scripts_showMyProfile.js"></script>
		<script src="../js/pages/scripts_listNote.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>
	
	<div id="fh5co-page">
		<div id="fh5co-wrap">



			<div id="fh5co-main">

				<!-- GRID OPERAZIONI -->

				<div id="fh5co-products" data-section="products">

				    <div class="container">
						<div class="row">
							<div class="col-md-8 col-md-offset-2 fh5co-section-heading text-center">
								<h2 class="fh5co-lead">HOME STUDENTE</h2>
								<p>Ciao <%=u.getName() %></p>
							</div>
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a id="listNote" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/search1.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Cerca appunti</h3>
									<p class="fh5co-figure-text">Trova, scarica e recensisci appunti condivisi dagli studenti.</p>
								</a>
							</div>
							
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="RequestForm.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/share.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Richiesta condivisione</h3>
									<p class="fh5co-figure-text">Invia una richiesta per condividere il tuo appunto.</p>
								</a>
							</div>
							
							<div class="clearfix visible-sm-block"></div>
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a id="btnProfile" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/profile.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza profilo</h3>
									<p class="fh5co-figure-text">Visualizza la tua bacheca e i tuoi dati.</p>
								</a>
							</div>
							
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a id="btn" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/searchStudente.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Trova studenti</h3>
									<p class="fh5co-figure-text">Cerca gli studenti iscritti, visualizza la loro bacheca</p>
								</a>
							</div>

							<div class="clearfix visible-sm-block"></div>


		
			        	</div>
				    </div>

				</div>

				<!-- END GRID OPERAZIONI -->


			</div>


	</div>

	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>