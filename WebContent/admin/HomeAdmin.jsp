<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,model.interfaces.UserInterface"%>
    
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
		<title>Home: Admin</title>
		
		<jsp:include page="/partials/includes.jsp"/>
		
		<script src="../js/pages/scripts_listRequest.js"></script>
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
								<a id="btn" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="../images/listrequest.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza richieste</h3>
									<p class="fh5co-figure-text">Visualizza la lista delle richieste in attesa di essere verificate.</p>
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