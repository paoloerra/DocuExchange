$(document).ready(function() {
	$("#search").click(function() {
		var course = $("#corso").val();
		var professor = $("#professori").val();
					$.ajax({
						url : "../StudentSearchNote",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"course" : course,
							"professor" : professor,
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
							showAlert(1,"Invio richiesta fallito");
						}
					});
	
					$(".preloader").hide();		
				return false;
		});

});
