$(document).ready(function() {
	$("#table tr").click(function(){
		   $(this).addClass('selected').siblings().removeClass('selected');    
		   var index=$(this).find('td:first').html();		   
		   $(".preloader").show();
			$.ajax({
				url : "../ServletAdmin?flag=2",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"index" : index,
				},
				success : function(msg) {
					if (!msg.result) {
						showAlert(1, "Errore");
					} else {
						window.location.href = msg.redirect;
					}
				},
				error : function(msg) {
					showAlert(1, "Impossibile Recuperare i dati.");
				}
			});

			$(".preloader").hide();
		});

});