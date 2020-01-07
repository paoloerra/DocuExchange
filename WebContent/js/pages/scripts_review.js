var count;
function starmark(item){
	count=item.id[0];
	sessionStorage.starRating = count;
	var subid= item.id.substring(1);
	for(var i=0;i<5;i++) {
		if(i<count) {
			document.getElementById((i+1)+subid).style.color="rgb(237, 138, 25)";
		} else {
			document.getElementById((i+1)+subid).style.color="black";
		}
	}
}
	
$(document).ready(function() {
	$("#btnreview").click(function() {
		var review = $("#review").val();
		var id = $("#id").val();
			if (review != "") {
					$.ajax({
						url : "../ServletStudent?flag=7",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"review" : review,
							"count" : count,
							"id" : id,
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
							showAlert(1,"Scrivi una recensione!");
						}
					});
	
					$(".preloader").hide();
					} else {
						showAlert(1,"Scrivi una recensione!.");
					}		
				return false;
		});

});
