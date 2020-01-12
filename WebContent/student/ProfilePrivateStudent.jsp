<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface, interfaces.NoteInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
<%
	String pageName = "ProfilePrivateStudent.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	Collection<?> Notes = (Collection<?>) request.getSession().getAttribute("MyNotes");
	System.out.println(Notes.size());
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Profilo: Studente</title>
		
		<jsp:include page="/partials/includes.jsp"/>
	
		<script src="../js/pages/scripts_ProfileEdit.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>
	
		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
					<div class="wrapper">
						<h1>PROFILO STUDENTE</h1>
						<form id="profile">
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Nome</div>
										<input id="name" type="text" type="text" value="<%=u.getName()%>" required>
									</div>
								<div class="inner-form">
									<div class="label">Cognome</div>
										<input id="surname" type="text" type="text" value="<%=u.getSurname()%>" required>
									</div>	
								<div class="inner-form">
									<div class="label">Email</div>
										<input id="email" type="text" type="text" value="<%=u.getEmail()%>" readonly>
								</div>
							</div>
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Sesso</div>
										<%if(u.getSex() == 'M') {%>
											<select id="sex">
											  <option value="M">Maschio</option>
											  <option value="F">Femmina</option>
											</select>
										<%} else {%>
											<select id="sex">
											  <option value="M">Femmina</option>
											  <option value="F">Maschio</option>
											</select>
										<%} %>	
								</div>
								<div class="inner-form">
									<div class="label">Password</div>
										<input id="password" type="password" type="text" value="<%=u.getPassword()%>" required>
								</div>
							</div>	
							<div class="middle-form">
								<div class="inner-form">
									<button id="btn" type="submit" class="btn">Modifica dati</button>
								</div>
							</div>							
							<h4>Appunti pubblicati</h1>
							<table class="table table-hover" style="color: #808080">
								<thead>
								 	<tr>
								      <th scope="col">Corso</th>
								      <th scope="col">Professore</th>
								      <th scope="col">Stato</th>
								      <th scope="col">Voto</th>
								    </tr>
								  </thead>
								  <tbody>
								  <%
									if(Notes != null && Notes.size() > 0) {
									int index = 0;
									String sex = "";
									Iterator<?> it = Notes.iterator();
									while(it.hasNext()){
										NoteInterface bean = (NoteInterface) it.next();
										String stato = "";
										if(bean.getChecked() == 0) {
											stato = "In attesa di verifica";
										}
										else if(bean.getChecked() == 1){
											stato = "Pubblicato";
										}
									%>
								    <tr>
								      <th hidden><%=index %></th>
								      <td><%=bean.getCourse() %></td>
								      <td><%=bean.getProfessor()%></td>
								      <% 
								      	if(bean.getChecked() == 0) {%>
										 	<td><div style="color:red;">In attesa di verifica</div></td>
										<% }
										else if(bean.getChecked() == 1){%>
										 	<td><div style="color:green;">Pubblicato</div></td>
										<% }%>
								      <td><small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small></td>
								    </tr>
								    <%
									index++;
								}
							} else {
								%>
							 	 <tr>
									<td colspan="3"><div style="text-align: center;">Non hai pubblicato appunti</div></td>
								 </tr>
								<%
							}
								%>
								  </tbody>
								</table>
					</div>
				</div>
		
				<!-- END REQUEST-->

		</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>