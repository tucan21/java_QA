package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Pawel")
            .withtLastname("Nowak").withAddress("Krakow").
                    withMobile("+48602852123").withEmail("adres@adres.com").withGroup("test1Group");
    app.contact().create(contact);

    /*app.contact().contactPage();
    app.contact().create(new ContactData("First Name2", "Last Name2",
            "addres2", "+48602852123", "adres2@adres.com", "test1"));*/

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}

