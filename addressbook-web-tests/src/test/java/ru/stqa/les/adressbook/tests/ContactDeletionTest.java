package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @Test
   public void testContactDeletion() {

      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().deleteSelectedContact();
   }
}
