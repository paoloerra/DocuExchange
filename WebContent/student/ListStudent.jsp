<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="controller.CheckSession,interfaces.UserInterface, java.util.LinkedList, java.util.Collection, java.util.*"%>
<%
	String pageName = "ListStudent.jsp";
	String pageFolder = "student";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
    UserInterface u = (UserInterface) session.getAttribute("user");
	if(!ck.isAllowed()){
		  response.sendRedirect(request.getContextPath()+"/Login.jsp");  
	}
	
	Collection<?> students = (Collection<?>) request.getSession().getAttribute("students");

%>
<!DOCTYPE html>
<html>
	<head>
		<title>Studenti</title>
		
		<jsp:include page="/partials/includes.jsp"/>
		
		<script src="../js/pages/scripts_searchStudent.js"></script>
		<script src="../js/pages/scripts_showProfile.js"></script>
	</head>
	<body>

	<jsp:include page="../partials/navbar.jsp"/>

	<div id="fh5co-page">
		<div id="fh5co-wrap">
			<div id="fh5co-main">
				<!-- TABELLA -->
					<div class="wrapper">
						<h1>STUDENTI</h1>
						<div class="form">
							<div class="top-form">
								<div class="inner-form">
								<form>
									<div class="label">Cerca per nome</div>
										<input type="text" id="student" required>										
									</div>
									<button type="submit" id="search" class="btn">Cerca</button>	
								</form>
							</div>		
						</div>
				<div style="width: 920px; height:600px; overflow-y: scroll;">
					<table id="table" class="table table-bordered table-striped table-hover" style="color: #808080">
						<tbody>
						<%
							if(students != null && students.size() > 0) {
								int index = 0;
								String sex = "";
								Iterator<?> it = students.iterator();
								while(it.hasNext()){
									UserInterface bean = (UserInterface) it.next();
									if(bean.getSex() == 'M') {
										sex = "../images/man.png";
									}
									else {
										sex = "../images/girl.png";
									}
						%>
							<tr>
								<td hidden><%=index %></td>
								<td><div style="text-align: center;"><img src=<%=sex%>></div></td>
							    <td><b>Nome: </b><%=bean.getName()%><br><br><b>Cognome: </b><%=bean.getSurname()%><br></td>							    						    
							</tr>
						<%
								index++;
							}
						} else {
						%>
						 	<tr>
								<td colspan="3"><div style="text-align: center;">NON CI SONO STUDENTI</div></td>
							 </tr>
						<%
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
				<!-- TABELLA -->


			</div>


	</div>

	<!-- FOOTER -->
	<jsp:include page="../partials/footer.jsp"/>




	</body>
</html>