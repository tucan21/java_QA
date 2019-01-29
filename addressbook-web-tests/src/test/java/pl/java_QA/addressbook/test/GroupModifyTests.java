package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

public class GroupModifyTests extends TestBase {

  @Test
  public void testGroupModifyTests() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().selectModifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("modify 123", "modify 123", "modify 123"));
    app.getGroupHelper().confirmModifyGroup();
    app.getGroupHelper().returnToGroupPage();
  }


}
