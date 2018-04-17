package ru.stqa.les.adressbook.tests;

<<<<<<< HEAD
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
=======
import org.openqa.selenium.By;
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

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


<<<<<<< HEAD
      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      app.contact().delete();
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() - 1);


      before.remove(index);
      Assert.assertEquals(before, after);
=======
      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().deleteSelectedContact();
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
   }

}
