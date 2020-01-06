$(document).ready(function() {
	$("#btn").click(function() {
		var name = $("#nome").val();
		var surname = $("#cognome").val();
		var email = $("#email").val();
		var e = document.getElementById("sesso");
		var sex = e.options[e.selectedIndex].text;		
		var password = $("#password").val();
		var verifyPassword = $("#VerificaPassword").val();
		
		if (nome != undefined && cognome != undefined && email != undefined && sesso != undefined && password != undefined && verifyPassword != undefined) {
			if (password != verifyPassword) {
				showAlert(1,"Controllare che le due password coincidano");
			} else {
				$.ajax({
					url : "ServletStudent?flag=1",
					type : "POST",
					dataType : 'JSON',
					async : false,
					data : {
						"nome" : name,
						"cognome" : surname,
						"sesso" : sex,
						"email" : email,
						"password" : password,
					},
					success : function(msg) {
						if (!msg.result) {
							showAlert(1,msg.error);
						} else {
							showAlert(0,msg.content);
							setTimeout(function() {
								window.location.href = msg.redirect;
							}, 500);
						}
					},
					error : function(msg) {
						showAlert(1,"Errore registrazione");
					}
				});

				$(".preloader").hide();
				}
				} else {
					showAlert(1,"Errore prelevamento campi.");
				}	
				return false;
		});

});
