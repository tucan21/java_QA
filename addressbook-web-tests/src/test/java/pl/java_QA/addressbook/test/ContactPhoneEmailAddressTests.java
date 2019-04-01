package pl.java_QA.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;
import pl.java_QA.addressbook.model.GroupData;
import pl.java_QA.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactPhoneEmailAddressTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test1"));
    }
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      //File photo = new File("src/test/resources/obrazek.png");
      app.contact().create(new ContactData()
              .withFirstname("Kamila").withtLastname("Potocka").withHomePhone("225894990")
              .withMobilePhone("502698990").withWorkPhone("225894990")
              .withEmail("kamila.potocka@niko.com").withEmail2("kamila.potocka@gmail.com")
              .inGroup(groups.iterator().next()));
    }
  }

  @Test
  public void testContactPhonesEmailsAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(margePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(margeEmails(contactInfoFromEditForm)));
  }

  private String margePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneEmailAddressTests::cleaned).collect(Collectors.joining("\n"));

  }

  private String margeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((t) -> !t.equals(""))
            .map(ContactPhoneEmailAddressTests::cleaned).collect(Collectors.joining("\n"));

  }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
}
}