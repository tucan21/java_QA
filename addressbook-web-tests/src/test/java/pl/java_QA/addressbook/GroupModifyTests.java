package pl.java_QA.addressbook;

import org.testng.annotations.Test;

public class GroupModifyTests extends TestBase {

  @Test
  public void testGroupModifyTests() throws Exception {
    goToGroupPage();
    selectGroup();
    selectModifyGroup();
    fillGroupForm(new GroupData("modify 123", "modify 123", "modify 123"));
    confirmModifyGroup();
    returnToGroupPage();
  }


}
