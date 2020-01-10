	
$(document).ready(function() {
	$("#download").click(function() {
		var id = $("#id").val();
					$.ajax({
						url : "../ServletDownload?flag=1",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"id" : id,
						},
					});
	
					$(".preloader").hide();		
				return false;
		});

});
