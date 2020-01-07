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
				
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="../css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/main.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>
	


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
						      <td><div style="text-align: center;"><a href="ViewRequest.jsp" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">2</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="ViewRequest.jsp" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">3</th>
						      <td><b>Professore:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="ViewRequest.jsp" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						     <tr>
						      <th scope="row">4</th>
						      <td><b>Titolo:</b><br><b>Corso:</b><br><b>Autore:</b><br>
						      </td>
						      <td><div style="text-align: center;"><a href="ViewRequest.jsp" class="badge badge-dark"><b>Visualizza</b></a></div></td>
						    </tr>
						  </tbody>
						</table>
					</div>
				<!-- TABELLA -->


			</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>