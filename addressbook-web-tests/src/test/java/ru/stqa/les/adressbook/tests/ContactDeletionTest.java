package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().gotoHomePage();
      if (app.contact().list().size() == 0) {
         app.contact().create(new ContactData()
                 .withName("oleg").withLastname("ivanov").withCity("Moscow")
                 .withTelephone("89996663322").withEmail("test@test.ru"));
      }
   }


   @Test
   public void testContactDeletion() {


      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      app.contact().delete();
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() - 1);


      before.remove(index);
      Assert.assertEquals(before, after);
   }

}
