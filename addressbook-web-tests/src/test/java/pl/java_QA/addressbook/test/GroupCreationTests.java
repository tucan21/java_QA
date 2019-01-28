package pl.java_QA.addressbook.test;


import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test1", "test1"));
    app.submitGroupCreation();
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test2", "test2", "test2"));
    app.submitGroupCreation();
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test3", "test3", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }

}
