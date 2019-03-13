package pl.java_QA.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressesTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Pawel")
              .withtLastname("Nowak").withAddress("Krakow")/*.withAddress2("Zakopane")*/
              .withMobilePhone("+48602 852 123").withWorkPhone("+48(22)6231254").withHomePhone("+48125219632")
              .withEmail("adres@adres.com")/*.withGroup("test1Group")*/.withEmail2("email2@email.com")
              .withEmail3("email3@email.com"));
    }
  }

  @Test
  public void testContactAddresses() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllAddresses(), equalTo(mergeAddresses(contactInfoFromEditForm)));

  }

  private String mergeAddresses(ContactData contact) {
    return Arrays.asList(contact.getAddress()).stream()
            .filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }


}
