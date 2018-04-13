package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


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
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      ContactData contact = new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru");
      app.getContactHelper().fillContactForm(contact);
      app.getContactHelper().updateSelectedContact();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(contact);
      Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
      
   }
}
