package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData().withFirstname("firstnameCreationD").withGroup("test1Group"));
    }
  }


  @Test
  public void testContactDeleteTests() throws Exception {
      Set<ContactData> before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedContact);
      Assert.assertEquals(before, after);
    }


  }
