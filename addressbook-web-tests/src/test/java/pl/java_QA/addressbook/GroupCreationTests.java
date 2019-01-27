package pl.java_QA.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test1", "test1"));
    submitGroupCreation();
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "test2", "test2"));
    submitGroupCreation();
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test3", "test3", "test3"));
    submitGroupCreation();
    returnToGroupPage();

  }

}
