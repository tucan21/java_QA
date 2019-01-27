package pl.java_QA.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeleteTests extends TestBase {

  public boolean acceptNextAlert = true;


  @Test
  public void testContactDeleteTests() throws Exception {
    wd.findElement(By.id("header")).click();
    wd.findElement(By.linkText("home")).click();
    wd.findElement(By.name("selected[]")).click();
    acceptNextAlert = true;
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    wd.findElement(By.linkText("home")).click();
  }


  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
