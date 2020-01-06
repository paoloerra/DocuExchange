$(document).ready(function() {
	$("#btnLogout").click(function() {
			console.log("Sono qui");
			$(".preloader").show();	
			
			$.ajax({
					url : '../ServletCommon?flag=4',
					type : "POST",
					dataType : 'JSON',
					async : true,
					success : function(msg) {
						if (!msg.result) {
							showAlert(1,msg.error);
						} else {
							showAlert(0,msg.content);
							setTimeout(function() {
								window.location.href = msg.redirect;
							}, 2000);
						}
					},
					error : function(msg) {
						showAlert(1,"Errore registrazione");
					}
				});

				$(".preloader").hide();
		 
				return false;
		});

});
