$(document).ready(function() {
	$("#btnLogout").click(function() {
			$(".preloader").show();	
			
			$.ajax({
					url : '../ServletCommon?flag=5',
					type : "POST",
					dataType : 'JSON',
					async : true,
					success : function(msg) {
						if (!msg.result) {
							showAlert(1,msg.error);
						} 
						else {
							window.location.href = msg.redirect;
						}
					},
					error : function(msg) {
						showAlert(1,"Errore");
					}
				});

				$(".preloader").hide();
		 
				return false;
		});

});
