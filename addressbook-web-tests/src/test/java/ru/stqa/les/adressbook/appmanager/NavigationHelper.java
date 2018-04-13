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

   public void groupPage() {
      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Groups")
              && isElementPresent(By.name("new"))) {
         return;
      }
      click(By.linkText("groups"));
   }


   public void gotoHomePage() {
      click(By.linkText("home"));
   }
}
