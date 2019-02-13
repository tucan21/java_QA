package pl.java_QA.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

import java.util.List;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletionTests() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}
