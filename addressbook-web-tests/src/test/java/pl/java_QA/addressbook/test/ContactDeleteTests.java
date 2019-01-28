package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {


  @Test
  public void testContactDeleteTests() throws Exception {
    app.goToContactPage();
    app.selectContact();
    app.deleteSelectedContact();
    app.confirmDelete();
    app.goToContactPage();
  }

}
