package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

public class GroupModifyTests extends TestBase {

  @Test
  public void testGroupModifyTests() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().selectModifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("modify 123", "modify 123", "modify 123"));
    app.getGroupHelper().confirmModifyGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }


}
