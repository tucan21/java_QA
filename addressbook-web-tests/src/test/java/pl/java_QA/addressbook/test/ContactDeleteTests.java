package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {


  @Test
  public void testContactDeleteTests() throws Exception {
    app.getContactHelper().goToContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("dupa", null,
              null, null, null, "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDelete();
    app.getContactHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
