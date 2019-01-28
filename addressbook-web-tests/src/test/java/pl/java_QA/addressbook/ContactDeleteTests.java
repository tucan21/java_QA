package pl.java_QA.addressbook;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {


  @Test
  public void testContactDeleteTests() throws Exception {
    goToContactPage();
    selectContact();
    deleteSelectedContact();
    confirmDelete();
    goToContactPage();
  }

}
