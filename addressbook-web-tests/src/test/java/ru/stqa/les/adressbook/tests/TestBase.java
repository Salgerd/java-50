package ru.stqa.les.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.les.adressbook.appmanager.ApplicationManager;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class TestBase {


   protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   @BeforeMethod
   public void setUp() throws Exception {
      app.init();
   }

   @AfterMethod
   public void tearDown() {
      app.stop();
   }


}
