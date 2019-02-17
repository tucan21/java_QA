package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModifyTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();

    if (app.contact().list().size() ==0) {
      app.contact().create(new ContactData("firstnameCreationM", null,
              null, null, null, "test1"));
    }
  }

  @Test
  public void testContactModifyTests() throws Exception {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "modify First Name 12",
            "modify Last Name 13", "modify adres 25",
            "+48854632521", "adres12@adres.com", null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
