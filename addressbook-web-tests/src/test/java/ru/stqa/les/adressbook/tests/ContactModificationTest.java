package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() {

      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().updateSelectedContact();
      app.getNavigationHelper().returnToHomePage();
      
   }
}
