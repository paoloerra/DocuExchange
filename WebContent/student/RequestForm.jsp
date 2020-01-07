<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession, interfacce.UserInterface"%>
<%
	String pageName = "RequestForm.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
    String email = u.getEmail();
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}	
%>
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
	
		<script src="../js/pages/scripts_request.js"></script>
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
						<form id="request" enctype="multipart/form-data">
							<div class="form">
								<div class="top-form">
									<div class="inner-form">
										<script>
											function random(){
												var a=document.getElementById('corso').value;
												console.log(a);
												//primo anno
												if(a == 'Programmazione I') {
													var array=["De Marco Gianluca , Zizza Rosalba", "Nappi Michele", "Tucci Maurizio , Distasi Riccardo"];
												}
												if(a == 'Architettura degli elaboratori') {
													var array=["Alberto Negro", "Anselmo Marcella", "Barbara Masucci"];
												}
												if(a == 'Matematica discreta') {
													var array=["Delizia Costantino", "Vincenzi Giovanni", "Lenzi Giacomo"];
												}
												if(a == 'Analisi Matematica') {
													var array=["Di Gironimo Patrizia", "Iovane Gerardo", "Benedetto Elmo"];
												}
												if(a == 'Programmazione e Strutture Dati') {
													var array=["Fuccella Vittorio", "Tucci Maurizio", "Deufemia Vincenzo"];
												}
												if(a == 'Metodi Matematici per Informatica') {
													var array=["De Felice Clelia", "Zaccagnino Rocco", "Rescigno Adele Anna"];
												}
												//secondo anno
												if(a == 'Sistemi operativi') {
													var array=["Rescigno Adele Anna , Abate Andrea Francesco", "Cattaneo Giuseppe", "Carpentieri Bruno"];
												}
												if(a == 'Programmazione Object Oriented') {
													var array=["Deufemia Vincenzo", "La Torre Salvatore", "Gravino Carmine"];
												}
												if(a == 'Basi di dati') {
													var array=["Sebillo Monica Maria Lucia", "Risi Michele , Tortora Genoveffa", "Polese Giuseppe"];
												}
												if(a == 'Calcolo delle probabilità e statistica matematica'){
													var array=["Di Crescenzo Antonio", "Giorno Virginia", "Martinucci Barbara"];
												}
												if(a == 'Tecnologie Software per il Web') {
													var array=["Risi Michele", "Francese Rita", "Costagliola Gennaro , Fuccella Vittorio"];
												}
												if(a == 'Reti di Calcolatori') {
													var array=["Malandrino Delfina , Zaccagnino Rocco", "Palmieri Francesco"];
												}
												if(a == 'Progettazione Algoritmi') {
													var array=["Vaccaro Ugo", "De Bonis Annalisa", "Anselmo Marcella"];
												}
												//terzo anno
												if(a == 'Ingegneria del software') {
													var array=["Ferrucci Filomena , Gravino Carmine", "De Lucia Andrea"];
												}
												if(a == 'Programmazione distribuita') {
													var array=["Malandrino Delfina", "Scarano Vittorio"];
												}
												if(a == 'Elementi di teoria della computazione') {
													var array=["Gargano Luisa", "De Felice Clelia"];
												}
												if(a == 'Ricerca operativa') {
													var array=["Cerulli Raffaele", "Carrabs Francesco"];
												}
												if(a == 'Calcolo scientifico') {
													var array=["Conte Dajana"];
												}
												if(a == 'Grafica ed Interattivita') {
													var array=["Abate Andrea Francesco"];
												}
												if(a == 'Sicurezza') {
													var array=["De Santis Alfredo"];
												}
												if(a == 'Programmazione avanzata') {
													var array=["De Bonis Annalisa"];
												}
												if(a == 'Interazione uomo macchina') {
													var array=["Vitiello Giuliana"];
												}
												//non ho messo gli esami a scelta perchè è inutile 
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
												<option>Analisi Matematica</option>
												<option>Programmazione e Strutture Dati</option>
												<option>Metodi Matematici per Informatica</option>
												<option>Programmazione Object Oriented</option>
												<option>Sistemi operativi</option>
												<option>Basi di dati</option>
												<option>Calcolo delle probabilità e statistica matematica</option>
												<option>Tecnologie Software per il Web</option>
												<option>Reti di Calcolatori</option>
												<option>Progettazione Algoritmi</option>												
												<option>Ingegneria del software</option>
												<option>Programmazione distribuita</option>												
												<option>Elementi di teoria della computazione</option>
												<option>Ricerca operativa</option>
												<option>Calcolo scientifico</option>
												<option>Grafica ed Interattivita</option>
												<option>Programmazione avanzata</option>
												<option>Interazione uomo macchina</option>
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
										<textarea id="description" placeholder="Descrizione appunto, argomenti trattati."></textarea>
									</div>
								</div>
								Inserisci PDF: <input type="file" accept="application/pdf" id="file_upload" name="file">
								<div class="middle-form">
									<div class="inner-form">
										<button id="btn" type="submit" class="btn">Invia</button>
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