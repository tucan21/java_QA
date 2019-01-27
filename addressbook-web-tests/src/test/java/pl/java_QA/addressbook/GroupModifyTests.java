package pl.java_QA.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModifyTests extends TestBase {

  @Test
  public void testGroupModifyTests() throws Exception {
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("selected[]")).click();
    wd.findElement(By.name("edit")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("modify 123");
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("modify 123");
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("modify 123");
    wd.findElement(By.name("update")).click();
    wd.findElement(By.linkText("group page")).click();
  }


  }
