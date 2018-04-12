package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.les.adressbook.model.ContactData;

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


   public void selectContactModification() {
      click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
   }

   public void deleteSelectedContact() {
      click(By.xpath("//div[@id='content']/form[2]/input[2]"));
   }

   public void submitContactModification() {
      click(By.name("modifiy"));
   }

   public void updateSelectedContact() {
      click(By.xpath("//div[@id='content']/form[1]/input[22]"));
   }

   public void createContact(ContactData contact) {

      gotoAddNewPage();
      fillContactForm(contact);
      submitForm();
      returnToHomePage();
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

   public int getContactCount() {

      return wd.findElements(By.name("selected[]")).size();
   }

}
