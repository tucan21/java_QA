package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    app.getContactHelper().goToContactPage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null,
              null, null, null, "test1"));
    }
    app.getContactHelper().selectModifyContact();
    app.getContactHelper().fillContactForm(new ContactData("modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com", null), false);
    app.getContactHelper().confirmModifyContact();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}
