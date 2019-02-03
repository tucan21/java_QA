package pl.java_QA.addressbook.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.java_QA.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }

}
