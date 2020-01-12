<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<title>Registrati</title>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
	
		<jsp:include page="/partials/includes.jsp"/>
		
		<script src="../js/pages/scripts_signUp.js"></script>
	</head>
	<body>

		<div id="fh5co-menu" class="navbar">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
                  		<a href="../Index.jsp"><img src="../images/DocuExchange_1.png" width="230" height="50" alt="simple logo"></a>
					</div>
				</div>
			</div>
		</div>
		
		<div id="fh5co-page">
			<div id="fh5co-wrap">
				<div id="fh5co-main">
			<!-- REGISTRATI-->
					<div class=" w3l-login-form">
			        	<form id="signUp">
			            	<div class=" w3l-form-group">
			                 	<label>Nome:</label>
			                  	<div class="group">
			                    	<input id="nome" type="text" class="form-control" required="required" />
			                  	</div>
			              	</div>
			             	 <div class=" w3l-form-group">
			                 	<label>Cognome:</label>
			                  	<div class="group">
			                    	<input id="cognome" type="text" class="form-control" required="required" />
			                  	</div>
			              	</div>
			               	<div class=" w3l-form-group">
			                	<label>Email:</label>
			                  	<div class="group">
			                    	<input id="email" type="text" class="form-control" placeholder="p.erra1@studenti.unisa.it" required="required" />
			                 	</div>
			              </div>
			              <div class=" w3l-form-group">
			              	<label>Sesso:</label>
			                <div class="group">
			                	<select id="sesso" class="form-control">
									<option value="M">Maschio</option>
									<option value="F">Femmina</option>
								</select>
			                 </div>
			              </div>
			              <div class=" w3l-form-group">
			              	<label>Password:</label>
			                <div class="group">
			                	<input id="password" type="password" class="form-control" required="required" />
			              	</div>
			              </div>
			              <div class=" w3l-form-group">
			              	<label>Verifica password:</label>
			                <div class="group">
			                	<input id="VerificaPassword" type="password" class="form-control" required="required" />
			              	</div>
			              </div>
			              <button id="btn" type="submit">Registrati</button>
			              <p class=" w3l-register-p">Hai un account?<a href="../Login.jsp" class="register"> Effettua il login</a></p>
			          </form>
			      </div>
		</div>
	</div>
	<jsp:include page="../partials/footer.jsp"/>
	</body>
</html>