$(document).ready(function() {
	$("#search").click(function() {
		console.log("sono qua");
		var autor = $("#autor").val();
		console.log(autor);
					$.ajax({
						url : "../ServletAdmin?flag=4",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"autor" : autor,
						},
						success : function(msg) {
							if (!msg.result) {
								showAlert(1,msg.error);
							} else {
								window.location.href = msg.redirect;
								showAlert(0,msg.content);
							}
						},
						error : function(msg) {
							showAlert(1,"Errore ricerca");
						}
					});
	
					$(".preloader").hide();		
				return false;
		});

});
