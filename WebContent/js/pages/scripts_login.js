$(document).ready(function() {
	$("#btn").click(function() {
		var email = $("#email").val();
		var password = $("#password").val();

		if (email != undefined && password != undefined) {
			$(".preloader").show();

			$.ajax({
				url : "ServletCommon?flag=1",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"email" : email,
					"password" : password,
				},
				success : function(msg) {
					if (!msg.result) {
						showAlert(1, "Login fallito.");
					} else {
						window.location.href = msg.redirect;
					}
				},
				error : function(msg) {
					showAlert(1, "Impossibile Recuperare i dati.");
				}
			});

			$(".preloader").hide();
		} else {
			showAlert(1, "Errore prelevamento dati.");
		}

		return false;
	});

});