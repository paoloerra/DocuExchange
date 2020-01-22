$(document).ready(function() {
	$("#btn").click(function() {
			console.log("Sono qui");
			$(".preloader").show();	
			
			$.ajax({
					url : '../AdminShowListRequest',
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
		});

});
