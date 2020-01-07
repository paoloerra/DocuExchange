<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession, interfacce.UserInterface, model.Note"%>
<%
	String pageName = "ViewRequest.jsp";
	String pageFolder = "admin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	
    Note req = (Note) session.getAttribute("req");
    int id_request = req.getIdNote();

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
		<link rel="stylesheet" href="..>/css/simple-line-icons.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/toastr.min.css">
		
		<script src="../js/jquery-3.4.1.min.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/jquery.magnific-popup.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	
		<script src="../js/pages/scripts_checkRequest.js"></script>
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/toastr.min.js"></script>
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
								<input id="id" type="text" value="<%=id_request%>" hidden>								
															
							</div>
							<div class="inner-form">
								<div class="label">Professore</div>
								<input type="text" type="text" value="<%=req.getProfessor()%>" readonly>
							</div>
							<div class="inner-form">
								<div class="label">Autore</div>
								<input type="text" type="text" value="<%=req.getAutor()%>" readonly>
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
						<button type="submit" class="btn">Scarica PDF</button>
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