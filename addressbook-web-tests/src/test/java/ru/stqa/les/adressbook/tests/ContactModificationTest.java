package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;


/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().fillContactForm(new ContactData("александр", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      app.getContactHelper().updateSelectedContact();
      app.getContactHelper().returnToHomePage();
      
   }
}
