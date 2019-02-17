package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData("firstnameCreationD", null,
              null, null, null, "test1"));
    }
  }


  @Test
  public void testContactDeleteTests() throws Exception {
    app.contact().contactPage();
    if (!app.contact().isThereAContact()) {
      if (app.contact().list().size() == 0) {
        app.contact().create(new ContactData("firstnameCreationD", null,
                null, null, null, "test1"));
      }
    }
      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      app.contact().delete(index);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(index);
      Assert.assertEquals(before, after);
    }


  }
