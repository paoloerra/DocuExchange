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

		<jsp:include page="../partials/navbar.jsp"/>
		


	<div id="fh5co-page">
		<div id="fh5co-wrap">



			<div id="fh5co-main">

			<!-- REQUEST -->
			<div class="wrapper">
			<h1>RICHIESTA CONDIVISIONE</h1>

			<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
				<div class="form">

					<div class="top-form">
								<div class="inner-form">
									<div class="label">Corso</div>
										<select>
										  <option value="volvo">Prova</option>
										  <option value="saab">Prova</option>
										  <option value="opel">Prova</option>
										  <option value="audi">Prova</option>
										</select>
								</div>

								<div class="inner-form">
									<div class="label">Professore</div>
										<select>
										  <option value="volvo">Prova</option>
										  <option value="saab">Prova</option>
										  <option value="opel">Prova</option>
										  <option value="audi">Prova</option>
										</select>
								</div>

						</div>

						
						<div class="bottom-form">
								<div class="inner-form">
									<textarea name="descrizione" placeholder="Descrizione appunto, argomenti trattati."></textarea>
								</div>
						</div>


					Inserisci PDF: <input type="file" name="image" required="required">



								<div class="middle-form">
								<div class="inner-form">
									<button type="submit" class="btn">Invia</button>
							</div>
						</div>

			</div>
			</form>
		</div>

		<!-- END REQUEST-->






		</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>