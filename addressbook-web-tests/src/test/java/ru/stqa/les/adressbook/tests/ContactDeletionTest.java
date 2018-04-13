package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @Test
   public void testContactDeletion() {


      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().deleteSelectedContact();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);


      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
   }
}
