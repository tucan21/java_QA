package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    app.goToContactPage();
    app.selectModifyContact();
    app.fillContactForm(new ContactData("modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com"));
    app.confirmModifyContact();
    app.returnToContactPage();
  }

}
