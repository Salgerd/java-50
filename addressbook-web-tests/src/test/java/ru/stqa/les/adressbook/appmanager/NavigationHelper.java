package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class NavigationHelper extends HelperBase{


   public NavigationHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoGroupPage() {
      click(By.linkText("groups"));
   }

   public void returnToHomePage() {
      click(By.linkText("home page"));
   }


   public void gotoAddNewPage() {
      click(By.linkText("add new"));
   }

}
