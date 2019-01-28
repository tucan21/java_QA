package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

public class GroupModifyTests extends TestBase {

  @Test
  public void testGroupModifyTests() throws Exception {
    app.goToGroupPage();
    app.selectGroup();
    app.selectModifyGroup();
    app.fillGroupForm(new GroupData("modify 123", "modify 123", "modify 123"));
    app.confirmModifyGroup();
    app.returnToGroupPage();
  }


}
