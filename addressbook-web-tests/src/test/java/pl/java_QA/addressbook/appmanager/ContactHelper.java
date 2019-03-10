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
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
//    attach(By.name("photo"), contactData.getPhoto());

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

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
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

  public void selectModifyContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void selectViewContactById(int id) {
    wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
  }

  public void contactPage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  /*public int count() {
    return wd.findElements(By.xpath("//img[@alt='Edit']")).size();
  }*/

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectModifyContactById(contact.getId());
    //selectModifyContact();
    fillContactForm(contact, false);
    confirmModifyContact();
    contactCache = null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    //selectContact();
    deleteSelectedContact();
    confirmDelete();
    contactCache = null;
    contactPage();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> trEntryOnlyElement = wd.findElements(By.name("entry"));
    for (WebElement singleRow : trEntryOnlyElement) {

      int id = Integer.parseInt(singleRow.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tds = singleRow.findElements(By.tagName("td"));
      String lastName = tds.get(1).getText();
      String firstName = tds.get(2).getText();
      String allPhones = tds.get(5).getText();
      String allAddresses = tds.get(3).getText();
      String allEmails = tds.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withtLastname(lastName)
              .withAllPhones(allPhones).withAllAddresses(allAddresses).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {
    selectModifyContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withtLastname(lastname).
            withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address).withAddress2(address2);
  }

  public ContactData infoFromViewForm(ContactData contact) {
    selectViewContactById(contact.getId());
    String info[] = wd.findElement(By.id("content")).getText().replaceAll("[-():]", "").replaceAll("[MWH]", "")
            .replaceAll("\\n+\\s*", "\n").replaceFirst(" ", "\n").split("\n");
    String email1 = wd.findElement(By.xpath("//a[contains(@href, 'mailto:email1')]")).getText();
    String email2 = wd.findElement(By.xpath("//a[contains(@href, 'mailto:email2')]")).getText();
    String email3 = wd.findElement(By.xpath("//a[contains(@href, 'mailto:email3')]")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(info[0]).withtLastname(info[1]).
            withAddress(info[2]).withHomePhone(info[3]).withMobilePhone(info[4]).withWorkPhone(info[5]).
            withEmail(email1).withEmail2(email2).withEmail3(email3);

  }
}

