$(document).ready(function() {
	var id = $("#id").val();
	var email = $("#email").val();
	var autor = $("#autor").val();
	console.log(email);
	console.log(autor);
	console.log(id);

	$("#btnAccepted").click(function() {

			$(".preloader").show();
			$.ajax({
				url : "../ServletAdmin?flag=3",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"outcome" : 1,
					"id" : id,
					"email" : email,
					"autor" : autor,
				},
				success : function(msg) {
					if (!msg.result) {
						showAlert(1, "Errore");
					} else {
						showAlert(0, "Richiesta accettata con successo");
						setTimeout(function() {
							window.location.href = msg.redirect;
						}, 2000);					}
				},
				error : function(msg) {
					showAlert(1, "Impossibile Recuperare i dati.");
				}
			});

			$(".preloader").hide();

		return false;
	});
	
	$("#btnRifiuted").click(function() {
		$(".preloader").show();
		$.ajax({
			url : "../ServletAdmin?flag=3",
			type : "POST",
			dataType : 'JSON',
			async : false,
			data : {
				"outcome" : 0,
				"id" : id,
				"email" : email,
				"autor" : autor,
			},
			success : function(msg) {
				if (!msg.result) {
					showAlert(1, "Errore");
				} else {
					showAlert(0, "Richiesta rifiutata con successo");
					setTimeout(function() {
						window.location.href = msg.redirect;
					}, 2000);					}
			},
			error : function(msg) {
				showAlert(1, "Impossibile Recuperare i dati.");
			}
		});

		$(".preloader").hide();

	return false;
});
	
	$("#download").click(function() {
		console.log("sono qua")
		$(".preloader").show();
		$.ajax({
			url : "../ServletAdmin?flag=3",
			type : "POST",
			dataType : 'JSON',
			async : false,
			data : {
				"outcome" : 0,
				"id" : id,
				"email" : email,
				"autor" : autor,
			},
			success : function(msg) {
				if (!msg.result) {
					showAlert(1, "Errore");
				} else {
					showAlert(0, "Richiesta rifiutata con successo");
					setTimeout(function() {
						window.location.href = msg.redirect;
					}, 2000);					}
			},
			error : function(msg) {
				showAlert(1, "Impossibile Recuperare i dati.");
			}
		});

		$(".preloader").hide();

	return false;
});
	

});