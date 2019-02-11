package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

public class ContactDeleteTests extends TestBase {


  @Test
  public void testContactDeleteTests() throws Exception {
    app.getContactHelper().goToContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("dupa", null,
              null, null, null, "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDelete();
    app.getContactHelper().goToContactPage();
  }

}
