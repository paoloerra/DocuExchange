<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,model.interfaces.UserInterface,model.interfaces.NoteInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
<%
	String pageName = "ListNote.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("profile");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	Collection<?> Notes = (Collection<?>) request.getSession().getAttribute("Notes");
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Appunti</title>
			
		<jsp:include page="/partials/includes.jsp"/>
	
		<script src="../js/pages/scripts_searchNote.js"></script>
		<script src="../js/pages/scripts_course.js"></script>
		<script src="../js/pages/scripts_showNote.js"></script>
	</head>
	<body>

		<jsp:include page="../partials/navbar.jsp"/>



	<div id="fh5co-page">
		<div id="fh5co-wrap">
			<div id="fh5co-main">
				<!-- TABELLA -->
					<div class="wrapper">
						<h1>APPUNTI CONDIVISI</h1>
						<form>
							<div class="form">
								<div class="top-form">
									<div class="inner-form">
										<div class="label">Cerca per corso:</div>
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
										<div class="label">Cerca per professore:</div>
											<div id='output'></div>
											<select id="professori">
												<div id='output'>
												
												</div>
											</select>
										</div>
									<div class="inner-form">
										<button id="search" class="btn">Cerca</button>
									</div>					
									</div>
								</div>
							</form>
							<div style="width: 920px; height:600px; overflow-y: scroll;">
							<table id="table" class="table table-hover" style="color: #808080">
						  		<tbody>
						  		<%
								if(Notes != null && Notes.size() > 0) {
								int index = 0;
								String sex = "";
								Iterator<?> it = Notes.iterator();
								while(it.hasNext()){
									NoteInterface bean = (NoteInterface) it.next();
									%>
							    	<tr>
							    		<td hidden><%=index %></td>
							      		<td><b>Professore: </b><%=bean.getProfessor() %><br><b>Corso: </b><%=bean.getCourse() %><br><b>Autore: </b><%=bean.getAutor()%><br></td>
							  			<td><br><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></td>
							   		</tr>
						    		<%
									index++;
								}
							} else {
								%>
									<div style="text-align: center; color: red">AL MOMENTO NON CI SONO APPUNTI</div>
								<%
							}
								%>
						  		</tbody>
							</table>
							</div>
						</div>
			</div>
	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>

	</body>
</html>