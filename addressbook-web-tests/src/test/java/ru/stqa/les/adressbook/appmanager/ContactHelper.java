package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
      type(By.name("home"), contactData.getTelephone());
      type(By.name("email"), contactData.getEmail());

     /* if (creation) {
         new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
         Assert.assertFalse(isElementPresent(By.name("new_group")));
      }*/
   }


   public void selectContactModificationById(int id) {
      wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
      click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

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
      returnToHomePage();
   }

   public void modifyContact(ContactData contact) {
      selectContactModificationById(contact.getId());
      fillContactForm(contact);
      updateSelectedContact();
      returnToHomePage();
   }


   public void delete(ContactData contact) {
      selectContactModificationById(contact.getId());
      deleteSelectedContact();
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


   public void gotoAddNewPage() {
      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
              && isElementPresent(By.name("submit"))) {
         return;
      }
      click(By.linkText("add new"));
   }

   public Set<ContactData> all() {

      Set<ContactData> contacts = new HashSet<ContactData>();
      List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
      for (WebElement element : elements) {
         int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
         String name = element.findElement(By.cssSelector("td:nth-child(3)")).getAttribute("textContent");
         String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getAttribute("textContent");
         contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
      }
      return contacts;
   }
}
