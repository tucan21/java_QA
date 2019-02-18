package pl.java_QA.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

import java.util.Set;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test1Group");
    app.group().create(group);


   /* app.goTo().groupPage();
    app.group().create(new GroupData ("test1", null, null));
    app.goTo().groupPage();
    app.group().create(new GroupData("test2", "test2", "test2"));
    app.goTo().groupPage();
    app.group().create(new GroupData("test3", "test3", "test3"));*/

    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }

}
