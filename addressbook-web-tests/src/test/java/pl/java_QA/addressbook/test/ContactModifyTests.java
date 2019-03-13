package pl.java_QA.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;
import pl.java_QA.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModifyTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstname("firstnameCreationM")/*.withGroup("test1Group")*/);
    }
  }

  @Test
  public void testContactModifyTests() throws Exception {

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstname("modify First Name 12")
            .withtLastname("modify Last Name 13").withAddress("modify adres 25")
            .withMobilePhone("+48854632521").withEmail("adres12@adres.com");
    app.goTo().contactPage();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    Contacts systemUnderTest = before.withOut(modifiedContact).withAdded(contact);
    assertEquals(new ArrayList<>(after).get(0).getFirstname(),
            new ArrayList<>(systemUnderTest).get(0).getFirstname());
    assertEquals(new ArrayList<>(after).get(0).getLastname(),
            new ArrayList<>(systemUnderTest).get(0).getLastname());
    assertEquals(new ArrayList<>(after).get(0).getAddress(),
            new ArrayList<>(systemUnderTest).get(0).getAddress());
    assertEquals(new ArrayList<>(after).get(0).getMobilePhone(),
            new ArrayList<>(systemUnderTest).get(0).getMobilePhone());
    assertEquals(new ArrayList<>(after).get(0).getEmail(),
            new ArrayList<>(systemUnderTest).get(0).getEmail());

    verifyContactListInUI();
  }

}
