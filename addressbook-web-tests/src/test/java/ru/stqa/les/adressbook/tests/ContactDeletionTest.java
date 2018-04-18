package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.List;
import java.util.Set;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().gotoHomePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
                 .withName("oleg").withLastname("ivanov").withCity("Moscow")
                 .withTelephone("89996663322").withEmail("test@test.ru"));
      }
   }


   @Test
   public void testContactDeletion() {


      Set<ContactData> before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() - 1);


      before.remove(deletedContact);
      Assert.assertEquals(before, after);
   }

}
