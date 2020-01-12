<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface,interfaces.NoteInterface, model.Note"%>
<%
	String pageName = "ViewRequest.jsp";
	String pageFolder = "admin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	
    NoteInterface req = (NoteInterface) session.getAttribute("req");
    int id_request = req.getId();

%>
<!DOCTYPE html>
<html>
	<head>
		<title>Richiesta</title>
		<jsp:include page="/partials/includes.jsp"/>
		<script src="../js/pages/scripts_checkRequest.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>
	
	<div id="fh5co-page">
		<div id="fh5co-wrap">
			<div id="fh5co-main">
				<!-- REQUEST -->
				<div class="wrapper">
				<h1>VERIFICA RICHIESTA</h1>
				<form id="form">
					<div class="form">
						<div class="top-form">
							<div class="inner-form">
								<div class="label">Corso</div>
								<input type="text" type="text" value="<%=req.getCourse()%>" readonly>	
								<input id="id" value="<%=id_request%>" hidden>								
															
							</div>
							<div class="inner-form">
								<div class="label">Professore</div>
								<input type="text" id="professor" value="<%=req.getProfessor()%>" readonly>
							</div>
							<div class="inner-form">
								<div class="label">Autore</div>
								<input type="text" id="autor" value="<%=req.getAutor()%>" readonly>
							</div>	
						</div>
						<div class="top-form">
							<div class="inner-form">
								<div class="label">Email autore </div>
								<input type="text" id="email" type="text" value="<%=req.getStudentEmail()%>" readonly>
							</div>
						</div>
						<div class="bottom-form">
							<div class="inner-form">
								<textarea readonly><%=req.getDescription()%></textarea>
							</div>
						</div>
						
						<a style="color:white" href="<%=request.getContextPath() %>/DownloaderServlet?flag=1&id=<%=id_request%>"'><div class="btn">Scarica PDF</div></a>
						
						<div class="middle-form">
							<div class="inner-form">
								<button id="btnAccepted" class="btn">Accetta</button>
								<button id="btnRifiuted" class="btn">Rifiuta</button>	
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