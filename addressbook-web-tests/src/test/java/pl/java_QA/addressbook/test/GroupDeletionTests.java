package pl.java_QA.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;
import pl.java_QA.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1Group"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    Groups after = app.db().groups();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
    verifyGroupListInUI();
  }


}
