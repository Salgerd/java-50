package ru.stqa.les.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

/**
 * Created by a.zelenskaya on 18.04.2018.
 */
public class ContactPhoneTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().gotoHomePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
                 .withName("oleg").withLastname("ivanov").withCity("Moscow")
                 .withHomePhone("89996663322").withEmail("test@test.ru"));
      }
   }
   @Test
   public void testContactPhone() {
      app.goTo().gotoHomePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
   }
}
