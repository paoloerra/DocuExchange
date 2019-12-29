<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Richieste</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		
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
						<h1>RICHIESTE</h1>
						<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Cerca per autore</div>
										<input type="text" name="professore" type="text" required>										
									</div>
									
									<button type="submit" class="btn">Cerca</button>
										
							</div>
							
					</div>
				</form>
				
				<table class="table table-bordered">
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="#" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">2</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="#" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">3</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="#" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">4</th>
						      <td><b>Titolo:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="#" class="badge badge-dark"><b>Visualizza</b></a></div></td>
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