package ru.stqa.les.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class ContactDeletionTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().gotoHomePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
                 .withName("oleg").withLastname("ivanov")
                 .withHomePhone("89996663322").withMobilePhone("89996663323").withWorkPhone("89996663324")
                 .withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru")
                 .withAddress("address1").withAddress2("address2"));
      }
   }


   @Test
   public void testContactDeletion() {


      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      assertEquals(app.contact().count(), before.size() - 1);
      Contacts after = app.contact().all();

      assertThat(after, equalTo(before.without(deletedContact)));
   }

}
