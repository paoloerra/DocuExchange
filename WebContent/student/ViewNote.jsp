RequestForm.jsp<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Appunto</title>
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
			<h1>APPUNTO</h1>

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
									<div class="label">Autore</div>
									<input type="text" name="Autore" type="text" required>
								</div>

								
						</div>
						

						
						<div class="bottom-form">
								<div class="inner-form">
									<textarea name="descrizione" placeholder="Descrizione appunto, argomenti trattati."></textarea>
								</div>
						</div>


						<button type="submit" class="btn">Scarica PDF</button>
						
						<h4>VALUTATO</h4>
						<img src="../images/starfull.png"><img src="../images/starfull.png"><img src="../images/starfull.png"><img src="../images/starfull.png">
						
						<div class="bottom-form"></div>
						
						
						

						<h4>RECENSIONI</h4>
						
							<div class="card-group">
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							</div>
							<div class="card-group">
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							  <div class="card">
							    <div class="card-body">
							      <h5 class="card-title">Paolo Erra</h5>
							      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
							    </div>
							    <div class="card-footer">
							      <small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small>
							    </div>
							  </div>
							</div>
							
						<div class="bottom-form"></div>
													
						<h4>FAI UNA RECENSIONE</h4>
					
						<div class="bottom-form">
							<div class="inner-form">
								<textarea name="Recensione" placeholder="Scrivi qui la tua recensione"></textarea>
							</div>
						</div>
						
						<small class="text-muted"><img src="../images/starempty.png"><img src="../images/starempty.png"><img src="../images/starempty.png"><img src="../images/starempty.png"></small>
						
						
						<div class="bottom-form">
								<div class="inner-form">
									<button type="submit" class="btn">Recensisci</button>
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