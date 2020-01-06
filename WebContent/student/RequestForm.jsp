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
		<link rel="stylesheet" href="../css/toastr.min.css">
		
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/toastr.min.js"></script>
	</head>
	<body>

		<jsp:include page="../partials/navbar.jsp"/>
		


	<div id="fh5co-page">
		<div id="fh5co-wrap">
			<div id="fh5co-main">
				<div class="wrapper">
					<h1>RICHIESTA CONDIVISIONE</h1>
						<form action="AdminInsertSmartphone" method="POST" enctype="multipart/form-data">
							<div class="form">
								<div class="top-form">
									<div class="inner-form">
										<script>
											function random(){
												var a=document.getElementById('corso').value;
												console.log(a);
												if(a == 'Programmazione I') {
													var array=["Zizza1", "Zizza2", "Zizza3"];
												}
												if(a == 'Architettura degli elaboratori') {
													var array=["Negro1", "Negro2", "Negro3"];
												}
												if(a == 'Matematica discreta'){
													var array=["Vincenzi1", "Vincenzi2", "Vincenzi3"];
												}
												var string = "";
												for(i = 0; i <array.length; i++) {
													string = string + "<option>"+array[i]+"</option>";
												}
												document.getElementById('professori').innerHTML = string;
											}
										</script>
										<div class="label">Corso</div>
											<select id="corso" onchange="random()">
												<option></option>
												<option>Programmazione I</option>
												<option>Architettura degli elaboratori</option>
												<option>Matematica discreta</option>
												<option>Programmazione Object Oriented</option>
												<option>Sistemi operativi</option>
												<option>Basi di dati</option>
												<option>Fisica</option>
												<option>Programmazione distribuita</option>
												<option>Programmazione avanzata</option>
												<option>Ingegneria del software</option>
												<option>Mobile programming</option>
												<option>Grafica e interattività</option>
												<option>Sicurezza</option>
												<option>Elementi di teoria della computazione</option>
												<option>Ricerca operativa</option>
												<option>Calcolo scientifico</option>  
											</select>
									</div>
									<div class="inner-form">
										<div class="label">Professore</div>
											<div id='output'></div>
											<select id="professori">
												<div id='output'>
												
												</div>
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
				</div>
			</div>
		<!-- FOOTER -->
		<jsp:include page="../partials/footer.jsp"/>
	</body>
</html>