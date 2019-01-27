package pl.java_QA.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("First Name", "Last Name", "addres", "+48602852123", "adres@adres.com"));
    submitContactCreation();
    initContactCreation();
    fillContactForm(new ContactData("First Name2", "Last Name2", "addres2", "+48602852123", "adres2@adres.com"));
    submitContactCreation();
  }


}

