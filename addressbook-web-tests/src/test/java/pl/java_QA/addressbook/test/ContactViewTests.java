package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactViewTests extends TestBase{

  @Test (enabled = false)
  public void ContactViewTests() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    app.goTo().contactPage();
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);
    assertThat(contact.getAllView(), equalTo(mergeAllView(contactInfoFromViewForm)));
    }


  private String mergeAllView(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(),
            contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
            contact.getAddress())
                    .stream().filter((s) -> !s.equals(""))
                    .map(ContactViewTests::cleaned)
                    .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
