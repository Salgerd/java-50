package ru.stqa.les.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.les.adressbook.appmanager.ApplicationManager;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class TestBase {


   protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   @BeforeSuite
   public void setUp() throws Exception {
      app.init();
   }

   @AfterSuite
   public void tearDown() {
      app.stop();
   }


}
