<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface,interfaces.NoteInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
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
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Appunti</title>
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
	
		<script src="../js/pages/scripts_showNote.js"></script>
		<script src="../js/pages/scripts.js"></script>
		<script src="../js/toastr.min.js"></script>
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
											<select>
										  		<option value="volvo">Prova</option>
										  		<option value="saab">Prova</option>
										  		<option value="opel">Prova</option>
										  		<option value="audi">Prova</option>
											</select>
									</div>
									<div class="inner-form">
										<div class="label">Cerca per professore:</div>
											<select>
										  		<option value="volvo">Prova</option>
										  		<option value="saab">Prova</option>
										  		<option value="opel">Prova</option>
										  		<option value="audi">Prova</option>
											</select>
										</div>
									<div class="inner-form">
										<div class="label">Cerca per autore</div>
											<input type="text" name="professore" type="text" required>										
										</div>					
									</div>
									<button type="submit" class="btn">Cerca</button>
								</div>
							</form>
							<table id="table" class="table table-bordered">
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
							  			<td><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></td>
							   		</tr>
						    		<%
									index++;
								}
							} else {
								%>
							 	 <tr>
									<td colspan="3"><div style="text-align: center;">AL MOMENTO NON CI SONO APPUNTI</div></td>
								 </tr>
								<%
							}
								%>
						  		</tbody>
							</table>
						</div>
			</div>
	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>

	</body>
</html>