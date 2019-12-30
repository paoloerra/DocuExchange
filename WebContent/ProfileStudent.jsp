RequestForm.jsp<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Profilo: Studente</title>
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
				<li class="active"><a href="HomeStudent.jsp" data-nav-section="home"><i class="icon-grid"></i> Home</a></li>
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
                  		<a href=""><img src="images/DocuExchange_1.png" width="230" height="50" alt="simple logo"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- END NAVBAR -->


		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
					<!-- PROFILO -->
					<div class="wrapper">
					<h1>PROFILO STUDENTE</h1>
					<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Nome</div>
										<input type="text" name="corso" type="text" required>
									</div>
		
								<div class="inner-form">
									<div class="label">Cognome</div>
										<input type="text" name="professore" type="text" required>
									</div>
										
								<div class="inner-form">
									<div class="label">Email</div>
										<input type="text" name="professore" type="text" required>
								</div>
							</div>
								
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Sesso</div>
										<select>
										  <option value="volvo">Maschio</option>
										  <option value="saab">Femmina</option>
										</select>
								</div>
								<div class="inner-form">
									<div class="label">Password</div>
										<input type="text" name="professore" type="text" required>
								</div>
							</div>
								
							<div class="middle-form">
								<div class="inner-form">
									<button type="submit" class="btn">Modifica dati</button>
								</div>
							</div>	
												
							<h4>Appunti pubblicati</h1>
							<table class="table table-hover">
								<thead>
								 	<tr>
								      <th scope="col">#</th>
								      <th scope="col">Corso</th>
								      <th scope="col">Professore</th>
								    </tr>
								  </thead>
								  <tbody>
								    <tr>
								      <th scope="row">1</th>
								      <td>Matematica discreta</td>
								      <td>Vincenzi</td>
								      <td><i class="icon-login"></i> Visualizza - Elimina <i class="icon-delete"></i></td>
								    </tr>
								    <tr>
								      <th scope="row">2</th>
								     <td>Matematica discreta</td>
								      <td>Vincenzi</td>
								      <td><i class="icon-login"></i> Visualizza - Elimina <i class="icon-delete"></i></td>
								    </tr>
								    <tr>
								      <th scope="row">3</th>
								      <td>Matematica discreta</td>
								      <td>Vincenzi</td>
								      <td><i class="icon-login"></i> Visualizza - Elimina <i class="icon-delete"></i></td>
								    </tr>
								  </tbody>
								</table>
					</div>
				</div>
		
				<!-- END REQUEST-->

		</div>


	</div>

	<!-- FOOTER -->
	<%@include file="footer.html" %>




	</body>
</html>