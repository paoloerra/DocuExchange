package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RequestTest.class , ReviewTest.class ,StudentTest.class ,NoteTest.class, CheckSessionTest.class , AdminTest.class, ServletAdminTest.class, ServletCommonTest.class, ServletStudentTest.class ,DownloadServletTest.class})
public class AllTests {

}
