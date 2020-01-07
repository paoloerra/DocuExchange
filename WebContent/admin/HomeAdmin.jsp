<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession, interfacce.UserInterface"%>
    
<%
	String pageName = "HomeAdmin.jsp";
	String pageFolder = "admin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Home: Admin</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="../css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/toastr.min.css">
		
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/pages/scripts_listStudent.js"></script>
		<script src="../js/toastr.min.js"></script>
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
								<h2 class="fh5co-lead">HOME ADMIN</h2>
							</div>


							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ListRequest.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/listrequest.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza richieste</h3>
									<p class="fh5co-figure-text">Visualizza la lista delle richieste in attesa di essere verificate.</p>
								</a>
							</div>
							
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ListStudent.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/liststudenti.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza studenti</h3>
									<p class="fh5co-figure-text">Visualizza la lista degli studenti iscritti alla piattaforma.</p>
								</a>
							</div>
							
							<div class="clearfix visible-sm-block"></div>
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ProfilePrivateAdmin.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/profile.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza profilo</h3>
									<p class="fh5co-figure-text">Visualizza i tuoi dati.</p>
								</a>
							</div>
							

							<div class="clearfix visible-sm-block"></div>


		
			        	</div>
				    </div>

				</div>

				<!-- END GRID OPERAZIONI -->


			</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>