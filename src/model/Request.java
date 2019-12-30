package model;

public class Request  {
		/**
		 * variables
		 */
		private int idRequest;
		private String studentEmail;
		private String adminEmail;
		private String corso;
		private String professore;
		private String descrizione;
		private String fileName;
		
		/**
		 * constructor
		 * @param idRequest id of the request
		 * @param adminEmail email of the admin
		 * @param studentEmail email of student
		 * @param corso name of course 
		 * @param professore name of professor
		 * @param descrizione description request
		 * @param fileName filename of note
		 */
		public Note(int idRequest,String adminEmail,String studentEmail,String corso,String professore,String descrizione,String fileName) {
			this.idRequest=idRequest;
			this.studentEmail=studentEmail;
			this.adminEmail=adminEmail;
			this.corso=corso;
			this.professore=professore;
			this.descrizione=descrizione;
			this.fileName=fileName;
		}
		/**
		 * empty constructor
		 */
		public Note() {}

		/**
		 * get email of admin
		 */
		public String getAdminEmail() {
			return adminEmail;
		}
		/**
		 * set email of admin
		 * @param adminEmail
		 */
		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		/**
		 * get id of request
		 */
		public int getIdRequest() {
			return idRequest;
		}
		/**
		 * set id of request
		 * @param idRequest
		 */

		public void setIdRequest(int idRequest) {
			this.idRequest = idRequest;
		}

		/**
		 * get email of student
		 */
		public String getStudentEmail() {
			return studentEmail;
		}

		/**
		 * set email of student
		 * @param studentEmail
		 */
		public void setStudentEmail(String studentEmail) {
			this.studentEmail = studentEmail;
		}

		/**
		 * get name of course
		 */
		public String getCorso() {
			return corso;
		}

		/**
		 * set the name of course
		 * @param corso
		 */
		public void setCorso(String corso) {
			this.corso = corso;
		}

		/**
		 * get the name of professor
		 
		 */
		public String getProfessore() {
			return professore;
		}

		/**
		 * set the name of professor
		 * @param professore
		 */
		public void setProfessore(String professore) {
			this.professore = professore;
		}

		/**
		 * get the description of the note
		 
		 */
		public String getDescrizione() {
			return descrizione;
		}

		/**
		 * set the descrption of note
		 * @param descrizione
		 */
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		/**
		 * get the filename of the note
		 
		 */
		public String getFileNamePDF() {
			return fileName;
		}

		/**
		 * set the filename of the note
		 * @param fileName
		 */
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	
}
