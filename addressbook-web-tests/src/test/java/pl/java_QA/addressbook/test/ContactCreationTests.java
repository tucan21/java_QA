package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().goToContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("First Name", "Last Name",
            "addres", "+48602852123", "adres@adres.com","test1"));
    app.getContactHelper().goToContactPage();
    app.getContactHelper().createContact(new ContactData("First Name2", "Last Name2",
            "addres2", "+48602852123", "adres2@adres.com","test1"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 2);
     }


}

