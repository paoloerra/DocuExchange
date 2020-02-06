package test;

import org.junit.Test;

import controller.SendEmail;

public class SendEmailTest {
	@Test
	public void SendRequestEmailTest() {
	    SendEmail.SendRequestEmail("m.derosa102@studenti.unisa.it","Michele","Programmazione I","Nappi Michele","Appunti");
    }
	
    @Test
    public void SendAcceptedEmailTest() {	 
    SendEmail.SendAcceptedEmail("m.derosa102@studenti.unisa.it", "Michele");
    }
    
    @Test
    public void SendRifiutedEmail() {
    	SendEmail.SendRifiutedEmail("m.derosa102@studenti.unisa.it", "Michele");
    }

}
