package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controller.SendEmail;

@RunWith(Suite.class)
@SuiteClasses({ SendEmailTest.class,
				AdminCheckRequestTest.class, 
				AdminSearchRequestTest.class, 
				AdminShowListRequestTest.class,
				AdminShowRequestTest.class, 
				AdminTest.class, 
				CheckSessionTest.class, 
				CommonEditProfileTest.class,
				CommonLoginTest.class,
				CommonLogoutTest.class, 
				DownloadServletTest.class, 
				NoteDAOTest.class, 
				NoteTest.class,
				RequestTest.class,
				ReviewDAOTest.class,
				ReviewTest.class, 
				StudentInsertReviewTest.class,
				StudentListNoteTest.class, 
				StudentListStudentTest.class, 
				StudentRegistrationTest.class,
				StudentSearchNoteTest.class, 
				StudentSearchStudentTest.class, 
				StudentSendRequestTest.class,
				StudentShowMyProfileTest.class,
				StudentShowNoteTest.class, 
				StudentShowProfileTest.class, 
				StudentTest.class,
				UserDAOTest.class })
public class AllTests {

}
