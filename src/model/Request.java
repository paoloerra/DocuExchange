package model;

public class Request  {
		private int idRequest;
		private String studentEmail;
		private String adminEmail;
		private String corso;
		private String professore;
		private String descrizione;
		private String fileName;
		
		
		public Note(int idRequest,String adminEmail,String studentEmail,String corso,String professore,String descrizione,String fileName) {
			this.idRequest=idRequest;
			this.studentEmail=studentEmail;
			this.adminEmail=adminEmail;
			this.corso=corso;
			this.professore=professore;
			this.descrizione=descrizione;
			this.fileName=fileName;
		}

		public Note() {}

		public String getAdminEmail() {
			return adminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		
		public int getIdRequest() {
			return idRequest;
		}


		public void setIdRequest(int idRequest) {
			this.idRequest = idRequest;
		}


		public String getStudentEmail() {
			return studentEmail;
		}


		public void setStudentEmail(String studentEmail) {
			this.studentEmail = studentEmail;
		}


		public String getCorso() {
			return corso;
		}


		public void setCorso(String corso) {
			this.corso = corso;
		}


		public String getProfessore() {
			return professore;
		}


		public void setProfessore(String professore) {
			this.professore = professore;
		}


		public String getDescrizione() {
			return descrizione;
		}


		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		public String getFileNamePDF() {
			return fileName;
		}


		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	
}
