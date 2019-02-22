package pl.java_QA.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.java_QA.addressbook.model.ContactData;
import pl.java_QA.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void confirmDelete() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }


  public void confirmModifyContact() {
    click(By.name("update"));
  }


  public void selectModifyContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void contactPage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectModifyContactById(contact.getId());
    fillContactForm(contact, false);
    confirmModifyContact();
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    confirmDelete();
    contactPage();
  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> trEntryOnlyElement = wd.findElements(By.name("entry"));
    for (WebElement singleRow : trEntryOnlyElement) {

      int id = Integer.parseInt(singleRow.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tds = singleRow.findElements(By.tagName("td"));
      String firstName = tds.get(2).getText();
      String lastName = tds.get(1).getText();

      contacts.add(new ContactData().withId(id).withFirstname(firstName).withtLastname(lastName));
    }
    return contacts;
  }


}

