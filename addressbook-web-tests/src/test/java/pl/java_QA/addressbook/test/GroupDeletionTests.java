package pl.java_QA.addressbook.test;


import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletionTests() {
    app.goToGroupPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }

}
