package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    app.getContactHelper().goToContactPage();
    app.getContactHelper().selectModifyContact();
    app.getContactHelper().fillContactForm(new ContactData("modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com", null), false);
    app.getContactHelper().confirmModifyContact();
    app.getContactHelper().returnToContactPage();
  }

}
