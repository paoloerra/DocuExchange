$(document).ready(function() {
	$("#search").click(function() {
		var student = $("#student").val();
		console.log(student);
					$.ajax({
						url : "../StudentSearchStudent",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"student" : student,
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
