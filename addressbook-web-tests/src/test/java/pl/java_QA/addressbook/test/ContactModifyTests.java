package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    app.getContactHelper().goToContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null,
              null, null, null, "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectModifyContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().confirmModifyContact();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
