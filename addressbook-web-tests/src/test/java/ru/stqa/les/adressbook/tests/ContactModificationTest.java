package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().gotoHomePage();
      if (app.contact().list().size() == 0) {
         app.contact().create(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
   }

   @Test
   public void testContactModification() {

      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      ContactData contact = new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru");
      app.contact().modify(contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(contact);
      Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
      
   }

}
