package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ApplicationManager {

   FirefoxDriver wd;

   private ContactHelper contactHelper;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;

   public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   public void init() {

      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Users/a.zelenskaya/Documents/Mozilla Firefox/firefox.exe"));
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      sessionHelper = new SessionHelper(wd);
      contactHelper = new ContactHelper(wd);
      sessionHelper.login("admin", "secret");
   }


   public void stop() {
      wd.quit();
   }


   public GroupHelper getGroupHelper() {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }

   public SessionHelper getSessionHelper() {
      return sessionHelper;
   }

   public ContactHelper getContactHelper() {
      return contactHelper;
   }
}