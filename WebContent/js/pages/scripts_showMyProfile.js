$(document).ready(function() {
	$("#btnProfile").click(function() {
					$.ajax({
						url : "../ServletStudent?flag=8",
						type : "POST",
						dataType : 'JSON',
						async : false,
						success : function(msg) {
							if (!msg.result) {
								showAlert(1,msg.error);
							} else {
									window.location.href = msg.redirect;
							}
						},
						error : function(msg) {
							showAlert(1,"Scrivi una recensione!");
						}
					});
	
					$(".preloader").hide();	
				return false;
		});

});
