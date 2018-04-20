package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.Contacts;

import java.util.List;


/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactHelper extends HelperBase {


   public ContactHelper(WebDriver wd) {

      super(wd);
   }

   public void submitForm() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
   }

   public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"), contactData.getName());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("address"), contactData.getCity());
      type(By.name("home"), contactData.getHomePhone());
      type(By.name("email"), contactData.getEmail());

     /* if (creation) {
         new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
         Assert.assertFalse(isElementPresent(By.name("new_group")));
      }*/
   }



   public void selectContactModificationById(int id) {
      WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
      WebElement row = checkbox.findElement(By.xpath("./../.."));
      List<WebElement> cells = row.findElements(By.tagName("td"));
      cells.get(7).findElement(By.tagName("a")).click();
     // click(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id)));
   }


   public void deleteSelectedContact() {
      click(By.xpath("//div[@id='content']/form[2]/input[2]"));
   }


   public void updateSelectedContact() {
      click(By.xpath("//div[@id='content']/form[1]/input[22]"));
   }

   public void create(ContactData contact) {

      gotoAddNewPage();
      fillContactForm(contact);
      submitForm();
     // contactCache = null;
      returnToHomePage();
   }

   public void modifyContact(ContactData contact) {
      selectContactModificationById(contact.getId());
      fillContactForm(contact);
      updateSelectedContact();
     // contactCache = null;
      returnToHomePage();
   }


   public void delete(ContactData contact) {
      selectContactModificationById(contact.getId());
      deleteSelectedContact();
     // contactCache = null;
   }

   public void returnToHomePage() {
      if (isElementPresent(By.id("maintable"))) {
         return;
      }
      click(By.linkText("home page"));
   }

   public boolean isThereAContact() {
      return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
   }

   public int count() {
      return wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).size();
   }


   public void gotoAddNewPage() {
      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
              && isElementPresent(By.name("submit"))) {
         return;
      }
      click(By.linkText("add new"));
   }

   //private Contacts contactCache = null;

   public Contacts all() {
    /*  if (contactCache != null) {
         return new Contacts(contactCache);
      }*/

      Contacts contacts = new Contacts();
      List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
      for (WebElement row : rows) {
         List<WebElement> cells = row.findElements(By.tagName("td"));
         int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
         String name = cells.get(1).getText();
         String lastname = cells.get(2).getText();
         String[] phones = cells.get(5).getText().split("\n");
         contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname).
                 withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
      }
      return contacts;
   }



   public ContactData infoFromEditForm(ContactData contact) {
      selectContactModificationById(contact.getId());
      String name = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String homephone = wd.findElement(By.name("home")).getAttribute("value");
      String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
      String workphone = wd.findElement(By.name("work")).getAttribute("value");
      wd.navigate().back();
      return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname)
              .withHomePhone(homephone).withMobilePhone(mobilephone).withWorkPhone(workphone);
   }


}
