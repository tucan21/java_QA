package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModifyTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();

    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstname("firstnameCreationM").withGroup("test1Group"));
    }
  }

  @Test
  public void testContactModifyTests() throws Exception {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstname("modify First Name 12")
            .withtLastname("modify Last Name 13").withAddress("modify adres 25")
            .withMobile("+48854632521").withEmail("adres12@adres.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
