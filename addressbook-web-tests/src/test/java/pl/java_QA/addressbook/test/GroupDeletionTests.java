package pl.java_QA.addressbook.test;


import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletionTests() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
