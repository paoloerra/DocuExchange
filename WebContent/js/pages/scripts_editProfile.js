$(document).ready(function() {
	$("#btn").click(function() {
		console.log("ciao");
		var name = $("#name").val();
		console.log(name);
		var surname = $("#surname").val();
		console.log(surname);
		var email = $("#email").val();
		console.log(email);
		var e = document.getElementById("sex");
		var sex = e.options[e.selectedIndex].text;	
		console.log(sex);
		var password = $("#password").val();
		console.log(password);

		if (email != undefined && password != undefined) {
			$(".preloader").show();

			$.ajax({
				url : "ServletCommon?flag=2",
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