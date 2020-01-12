<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface"%>
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
		<title>Richiesta</title>		
		<jsp:include page="/partials/includes.jsp"/>
		<script src="../js/pages/scripts_course.js"></script>
		<script src="../js/pages/scripts_request.js"></script>
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