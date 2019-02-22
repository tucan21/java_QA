package pl.java_QA.addressbook.test;

import org.testng.annotations.Test;
import pl.java_QA.addressbook.model.GroupData;
import pl.java_QA.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1Group");
    app.group().create(group);


   /* app.goTo().groupPage();
    app.group().create(new GroupData ("test1", null, null));
    app.goTo().groupPage();
    app.group().create(new GroupData("test2", "test2", "test2"));
    app.goTo().groupPage();
    app.group().create(new GroupData("test3", "test3", "test3"));*/

    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));


    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
