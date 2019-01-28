package pl.java_QA.addressbook;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    goToContactPage();
    selectModifyContact();
    fillContactForm(new ContactData("modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com"));
    confirmModifyContact();
    returnToContactPage();
  }

}
