$(document).ready(function() {
	$("#btn").click(function() {
		var course = $("#corso").val();
		console.log(course);
		var professor = $("#professori").val();
		console.log(professor);
		var description = $("#description").val();
		console.log(description);

		
		if (course != undefined && professor != undefined && description != undefined) {
				$.ajax({
					url : "../ServletStudent?flag=2",
					type : "POST",
					dataType : 'JSON',
					async : false,
					data : {
						"course" : course,
						"professor" : professor,
						"description" : description,
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
						showAlert(1,"Invio richiesta fallito");
					}
				});

				$(".preloader").hide();
				} else {
					showAlert(1,"Errore prelevamento campi.");
				}	
				return false;
		});

});
