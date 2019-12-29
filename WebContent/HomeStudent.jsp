<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Home: Studente</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="css/icomoon.css">
		<link rel="stylesheet" href="css/simple-line-icons.css">
		<link rel="stylesheet" href="css/style.css">
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/main.js"></script>
	</head>
	<body>

		<!-- NAVBAR -->
		<div id="fh5co-offcanvass">
			<ul>
				<li><a href="#"><i class="icon-user"></i> Studente: </a></li>
				<li><a href="#"><i class="icon-download"></i> Download disponibili: </a></li>
				<li><a href="#"><i class="icon-logout"></i> Logout</a></li>
			</ul>
		</div>
		
		<div id="fh5co-menu" class="navbar">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>					
                  		<a href="HomeStuent.jsp"><img src="images/DocuExchange_1.png" width="230" height="50" alt="simple logo"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- END NAVBAR -->


	<div id="fh5co-page">
		<div id="fh5co-wrap">



			<div id="fh5co-main">

				<!-- GRID OPERAZIONI -->

				<div id="fh5co-products" data-section="products">

				    <div class="container">
						<div class="row">
							<div class="col-md-8 col-md-offset-2 fh5co-section-heading text-center">
								<h2 class="fh5co-lead">HOME STUDENTE</h2>
								<p>Ciao Paolo</p>
							</div>


							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ListNote.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="images/search1.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Cerca appunti</h3>
									<p class="fh5co-figure-text">Trova, scarica e recensisci appunti condivisi dagli studenti.</p>
								</a>
							</div>
							
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="RequestForm.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="images/share.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Richiesta condivisione</h3>
									<p class="fh5co-figure-text">Invia una richiesta per condividere il tuo appunto.</p>
								</a>
							</div>
							
							<div class="clearfix visible-sm-block"></div>
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ProfileStudent.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="images/profile.png" class="img-responsive"></div>
									</figure>
									<h3 class="fh5co-figure-lead">Visualizza profilo</h3>
									<p class="fh5co-figure-text">Visualizza la tua bacheca e i tuoi dati.</p>
								</a>
							</div>
							
							<div class="col-md-3 col-sm-6 col-xs-6 col-xxs-12">
								<a href="ListStudent.jsp" class="fh5co-figure">
									<figure>
										<div class="imageHome"><img src="images/searchStudente.png" class="img-responsive"></div>
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

	<!-- FOOTER -->
	<%@include file="footer.html" %>




	</body>
</html>