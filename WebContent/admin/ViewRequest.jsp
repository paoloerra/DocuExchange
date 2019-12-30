RequestForm.jsp<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Richiesta</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="../css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/main.js"></script>
	</head>
	<body>

		<!-- NAVBAR -->
		<div id="fh5co-offcanvass">
			<ul>
				<li class="active"><a href="HomeAdmin.jsp" data-nav-section="home"><i class="icon-grid"></i> Home</a></li>
				<li><a href="#"><i class="icon-user"></i> Admin: </a></li>
				<li><a href="#"><i class="icon-logout"></i> Logout</a></li>
			</ul>
		</div>
		
		<div id="fh5co-menu" class="navbar">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>					
                  		<a href="#"><img src="../images/DocuExchange_1.png" width="230" height="50" alt="simple logo"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- END NAVBAR -->


	<div id="fh5co-page">
		<div id="fh5co-wrap">



			<div id="fh5co-main">

			<!-- REQUEST -->
			<div class="wrapper">
			<h1>VERIFICA RICHIESTA</h1>

			<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
				<div class="form">

					<div class="top-form">
								<div class="inner-form">
									<div class="label">Corso</div>
									<input type="text" name="corso" type="text" required>
								</div>

								<div class="inner-form">
									<div class="label">Professore</div>
										<input type="text" name="professore" type="text" required>
								</div>
								
								<div class="inner-form">
									<div class="label">Studente</div>
									<input type="text" name="studente" type="text" required>
								</div>

								
						</div>
						
						<div class="top-form">
								

								<div class="inner-form">
									<div class="label">Email </div>
									<input type="text" name="email" type="text" required>
								</div>


						</div>

						
						<div class="bottom-form">
								<div class="inner-form">
									<textarea name="descrizione" placeholder="Descrizione appunto, argomenti trattati."></textarea>
								</div>
						</div>


						<button type="submit" class="btn">Scarica PDF</button>



								<div class="middle-form">
								<div class="inner-form">
									<button type="submit" class="btn">Accetta</button>
									<button type="submit" class="btn">Rifiuta</button>
									
							</div>
						</div>

			</div>
			</form>
		</div>

		<!-- END REQUEST-->






		</div>


	</div>

	<!-- FOOTER -->
	<%@include file="../footer.html" %>




	</body>
</html>