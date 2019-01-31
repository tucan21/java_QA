package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {


  @Test
  public void testContactDeleteTests() throws Exception {
    app.getContactHelper().goToContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDelete();
    app.getContactHelper().goToContactPage();
  }

}
