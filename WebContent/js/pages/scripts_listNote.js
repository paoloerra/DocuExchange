$(document).ready(function() {
	$("#listNote").click(function() {
			$(".preloader").show();	
			
			$.ajax({
					url : '../StudentListNote',
					type : "POST",
					dataType : 'JSON',
					async : true,
					success : function(msg) {
						if (!msg.result) {
							showAlert(1,msg.error);
						} else {
								window.location.href = msg.redirect;
							
						}
					},
					error : function(msg) {
						showAlert(1,"Errore");
					}
				});

			$(".preloader").hide();
			//location.assign("../student/ListStudent.jsp")

		 
		});

});
