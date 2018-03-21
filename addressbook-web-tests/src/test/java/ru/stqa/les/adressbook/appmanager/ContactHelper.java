package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.les.adressbook.model.ContactData;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactHelper extends HelperBase{


   public ContactHelper(FirefoxDriver wd) {

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
   }
}
