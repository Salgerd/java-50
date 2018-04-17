package ru.stqa.les.adressbook.tests;

<<<<<<< HEAD
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
=======
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)


/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactModificationTest extends TestBase {

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
   public void testContactModification() {

<<<<<<< HEAD
      List<ContactData> before = app.contact().list();
      int index = before.size() - 1;
      ContactData contact = new ContactData()
              .withName("oleg").withLastname("ivanov").withCity("Moscow")
              .withTelephone("89996663322").withEmail("test@test.ru");
      app.contact().modify(contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(contact);
      Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
=======
      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      }
      app.getContactHelper().selectContactModification();
      app.getContactHelper().submitContactModification();
      app.getContactHelper().fillContactForm(new ContactData("александр", "ivanov", "Moscow", "89996663322", "test@test.ru"));
      app.getContactHelper().updateSelectedContact();
      app.getContactHelper().returnToHomePage();
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
      
   }

}
