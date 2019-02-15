package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().goToContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Cokolwiek", "Last Name",
            "addres", "+48602852123", "adres@adres.com", "test1");
    app.getContactHelper().createContact(contact);

    /*app.getContactHelper().goToContactPage();
    app.getContactHelper().createContact(new ContactData("First Name2", "Last Name2",
            "addres2", "+48602852123", "adres2@adres.com", "test1"));*/

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}

