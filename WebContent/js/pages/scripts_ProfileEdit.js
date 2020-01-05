$(document).ready(function() {
	$("#btn").click(function() {
		var name = $("#name").val();
		console.log(name);
		var surname = $("#surname").val();
		console.log(surname);
		var email = $("#email").val();
		console.log(email);
		var e = document.getElementById("sex");
		var sex = e.options[e.selectedIndex].text;	
		console.log(sex);
		var password = $("#password").val();
		console.log(password);
		
		if (name != undefined && surname != undefined && email != undefined && sex != undefined && password != undefined) {
			console.log("Sono qui");
			$(".preloader").show();	
			
			$.ajax({
					url : '../ServletCommon?flag=2',
					type : "POST",
					dataType : 'JSON',
					async : true,
					data : {
						"name" : name,
						"surname" : surname,
						"sex" : sex,
						"email" : email,
						"password" : password,
					},
					success : function(msg) {
						if (!msg.result) {
							showAlert(1,msg.error);
						} else {
							showAlert(0,msg.content);
						}
					},
					error : function(msg) {
						showAlert(1,"Errore modifica del profilo");
					}
				});

				$(".preloader").hide();
				} else {
					showAlert(1,"Errore prelevamento campi.");
				}	
				return false;
		});

});
