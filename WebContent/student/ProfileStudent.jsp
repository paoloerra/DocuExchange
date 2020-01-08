<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession, java.util.ArrayList,interfaces.UserInterface, interfaces.NoteInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
<%
	String pageName = "ProfileStudent.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("profile");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	Collection<?> notes = (Collection<?>) request.getSession().getAttribute("NotesStudent");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Profilo: <%=u.getName()%></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="../css/icomoon.css">
		<link rel="stylesheet" href="..>/css/simple-line-icons.css">
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
						<h1>PROFILO DI <%=u.getName()%></h1>
						<form id="profile">
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Nome</div>
										<input id="name" type="text" type="text" value="<%=u.getName()%>" readonly>
									</div>
								<div class="inner-form">
									<div class="label">Cognome</div>
										<input id="surname" type="text" type="text" value="<%=u.getSurname()%>" readonly>
									</div>	
								<div class="inner-form">
									<div class="label">Email</div>
										<input id="email" type="text" type="text" value="<%=u.getEmail()%>" readonly>
								</div>
							</div>
							<div class="top-form">
								<div class="inner-form">
									<div class="label">Sesso</div>
										<input id="sex" type="text" type="text" value="<%=u.getEmail()%>" readonly>
								</div>
							</div>	
							<div class="middle-form"></div>	
							</div>							
							<h4>Appunti pubblicati</h1>
							<table id="table" class="table table-hover">
								<thead>
								 	<tr>
								      <th scope="col">Corso</th>
								      <th scope="col">Professore</th>
								      <th scope="col">Voto</th>
								      
								    </tr>
								  </thead>
								  <tbody>
								  <%
									if(notes != null && notes.size() > 0) {
										int index = 0;
										Iterator<?> it = notes.iterator();
										while(it.hasNext()){
											NoteInterface bean = (NoteInterface) it.next();
									  %>
										    <tr>
										      <td hidden><%=bean.getId() %></td>
										      <td><%=bean.getCourse() %></td>
										      <td><%=bean.getProfessor() %></td>
										      <td><small class="text-muted"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></small></td>
										    </tr>
										<%
											index++;
										}
									} else {
									%>
									 	<tr>
											<td colspan="5"><div><%=u.getName()%> non ha pubblicato appunti.</div></td>
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