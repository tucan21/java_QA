package pl.java_QA.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {

  @Test
  public void testContactModifyTests() throws Exception {
    wd.findElement(By.linkText("home")).click();
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("modify First Name 12");
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("modify Last Name 13");
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("modify adres 25");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("+48854632521");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("adres12@adres.com");
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    wd.findElement(By.linkText("home page")).click();
  }


  }
