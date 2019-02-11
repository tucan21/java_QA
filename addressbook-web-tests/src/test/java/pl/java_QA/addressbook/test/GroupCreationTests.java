package pl.java_QA.addressbook.test;


import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData ("test1", null, null));
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData ("test1", null, null));
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test2", "test2", "test2"));
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test3", "test3", "test3"));


  }

}
