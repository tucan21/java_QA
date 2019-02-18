package pl.java_QA.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;

import java.util.Set;

public class GroupModifyTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();

    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1Group"));
    }
  }

  @Test
  public void testGroupModifyTests() throws Exception {

    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("modify 123").withFooter("modify 123").withHeader("modify 123");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
