package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @Test
   public void testContactDeletion() {


      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().deleteSelectedContact();
   }
}
