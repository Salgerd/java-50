package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() {

      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().fillContactForm(new ContactData("александр", "ivanov", "Moscow", "89996663322", "test@test.ru",null), false);
      app.getContactHelper().updateSelectedContact();
      app.getNavigationHelper().returnToHomePage();
      
   }
}
