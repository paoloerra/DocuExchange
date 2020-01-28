<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,model.interfaces.UserInterface"%>
    
<%
	String pageName = "ProfilePrivateAdmin.jsp";
	String pageFolder = "admin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Profilo: Admin</title>
		
		<jsp:include page="/partials/includes.jsp"/>	
		<script src="../js/pages/scripts_ProfileEdit.js"></script>
		
	</head>
	<body>

		<jsp:include page="../partials/navbar.jsp"/>
		


		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
					<!-- PROFILO -->
					<div class="wrapper">
					<h1>PROFILO ADMIN</h1>
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