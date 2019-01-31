package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("First Name", "Last Name", "addres", "+48602852123", "adres@adres.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("First Name2", "Last Name2", "addres2", "+48602852123", "adres2@adres.com"));
    app.getContactHelper().submitContactCreation();
  }


}

