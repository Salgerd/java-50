package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class HelperBase {


   protected FirefoxDriver wd;

   public HelperBase(FirefoxDriver wd) {
      this.wd = wd;
   }

   protected void click(By locator) {
      wd.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
   }
}