<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Appunti</title>
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

				<!-- TABELLA -->
					<div class="wrapper">
						<h1>APPUNTI CONDIVISI</h1>
						<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Cerca per corso:</div>
										<select>
										  <option value="volvo">Prova</option>
										  <option value="saab">Prova</option>
										  <option value="opel">Prova</option>
										  <option value="audi">Prova</option>
										</select>
									</div>
									<div class="inner-form">
										<div class="label">Cerca per professore:</div>
										<select>
										  <option value="volvo">Prova</option>
										  <option value="saab">Prova</option>
										  <option value="opel">Prova</option>
										  <option value="audi">Prova</option>
										</select>
									</div>
								<div class="inner-form">
									<div class="label">Cerca per autore</div>
										<input type="text" name="professore" type="text" required>										
									</div>					
							</div>
							<button type="submit" class="btn">Cerca</button>
							
					</div>
				</form>
				
						<table class="table table-bordered">
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><a href="#" class="badge badge-dark"><b>Visualizza</b></a></td>
						      <td><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"></td>
						    </tr>
						     <tr>
						      <th scope="row">2</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><a href="#" class="badge badge-dark"><b>Visualizza</b></a></td>
						      <td><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"></td>
						    </tr>
						     <tr>
						      <th scope="row">3</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><a href="#" class="badge badge-dark"><b>Visualizza</b></a></td>
						      <td><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"></td>
						    </tr>
						     <tr>
						      <th scope="row">4</th>
						      <td><b>Titolo:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><a href="#" class="badge badge-dark"><b>Visualizza</b></a></td>
						      <td><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"><img src="images/star.png"></td>
						    </tr>
						  </tbody>
						</table>
					</div>
				<!-- TABELLA -->


			</div>


	</div>

	<!-- FOOTER -->
	<%@include file="footer.html" %>




	</body>
</html>