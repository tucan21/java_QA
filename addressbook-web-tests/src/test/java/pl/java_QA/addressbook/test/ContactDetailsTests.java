package pl.java_QA.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.dnd.SerializationTester.stream;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      File photo = new File("src/test/resources/obrazek.png");
      app.contact().create(new ContactData()
              .withFirstname("Anna").withtLastname("Romanow").withPhoto(photo).
                      withHomePhone("225894990").withMobilePhone("502698990").withWorkPhone("225894990")
              .withEmail("kamila.potocka@niko.com").withEmail2("Anna.Romanow@abc.com")/*.withGroup("[none]")*/);
    }
  }


  @Test(enabled = false)
  public void testContactDetails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
    assertThat(margeDetails(contactInfoFromEditForm), equalTo(cleanedPhones(contactInfoFromDetailsForm.getName())));
  }
  private String margeTitle(ContactData contact) {
    return Stream.of((contact.getFirstname() + " " + contact.getLastname()).trim(), (contact.getPhoto().getAbsolutePath())).filter((n) -> !n.equals("")).collect(Collectors.joining("\n"));
  }

  private String margePhonesForDetails(ContactData contact) {
    return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).filter((p) -> !p.equals("")).collect(joining("\n"));
            .stream().filter((p) -> !p.equals("")).map(ContactPhoneEmailAddressTests::cleaned).collect(Collectors.joining("\n"));
  }

  private String margeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((t) -> !t.equals(""))
            .map(ContactPhoneEmailAddressTests::cleaned).collect(joining("\n"));
            .stream().filter((t) -> !t.equals("")).collect(Collectors.joining("\n"));
  }

  private String margeDetails(ContactData contact) {
    return Arrays.asList(margeTitle(contact), margePhonesForDetails(contact), margeEmails(contact))
            .stream().filter((d) -> !d.equals("")).collect(Collectors.joining("\n\n"));
  }

  public String cleanedPhones (String name){
    public String cleanedPhones(String name) {
      return name.replaceAll("[A-Z]: ", "");
    }

  }
