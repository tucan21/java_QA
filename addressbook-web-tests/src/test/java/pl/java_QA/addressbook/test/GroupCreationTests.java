package pl.java_QA.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("test1Group", null, null);
    app.group().create(group);


   /* app.goTo().groupPage();
    app.group().create(new GroupData ("test1", null, null));
    app.goTo().groupPage();
    app.group().create(new GroupData("test2", "test2", "test2"));
    app.goTo().groupPage();
    app.group().create(new GroupData("test3", "test3", "test3"));*/

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
