package pl.java_QA.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupHelper().createGroup(group);


   /* app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData ("test1", null, null));
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test2", "test2", "test2"));
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test3", "test3", "test3"));*/

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(group);
    Comparator<?super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
