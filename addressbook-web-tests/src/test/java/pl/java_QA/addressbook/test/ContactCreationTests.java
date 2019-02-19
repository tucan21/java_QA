package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Pawel")
            .withtLastname("Nowak").withAddress("Krakow").
                    withMobile("+48602852123").withEmail("adres@adres.com").withGroup("test1Group");
    app.contact().create(contact);

    /*app.contact().contactPage();
    app.contact().create(new ContactData("First Name2", "Last Name2",
            "addres2", "+48602852123", "adres2@adres.com", "test1"));*/

    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);


  }

}

