$(document).ready(function() {
	$("#btn").click(function() {
		var course = $("#corso").val();
		console.log(course);
		var professor = $("#professori").val();
		console.log(professor);
		var description = $("#description").val();
		console.log(description);
		var file_upload = $("#file_upload").val();
		console.log(file_upload);
		var ext = file_upload.substring(file_upload.lastIndexOf('.')+1);
		console.log(ext);
		if(ext != "pdf"){
			showAlert(1, "Inserisci un file pdf");
			return false;
		} else {
			if (course != undefined && professor != undefined && description != undefined) {
					$.ajax({
						url : "../StudentSendRequest",
						type : "POST",
						dataType : 'JSON',
						async : false,
						data : {
							"course" : course,
							"professor" : professor,
							"description" : description,
							"file_upload" : file_upload,
						},
						success : function(msg) {
							if (!msg.result) {
								showAlert(1,msg.error);
							} else {
								showAlert(0,msg.content);
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
			}	
				return false;
		});

});
