package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;
import pl.java_QA.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Pawel")
            .withtLastname("Nowak").withAddress("Krakow")/*.withAddress2("Zakopane")*/
            .withMobilePhone("+48602 852 123").withWorkPhone("+48(22)6231254").withHomePhone("+48125219632")
            .withEmail("adres@adres.com").withGroup("test1Group").withEmail2("email2@email.com")
            .withEmail3("email3@email.com");
    app.contact().create(contact);

    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

}

