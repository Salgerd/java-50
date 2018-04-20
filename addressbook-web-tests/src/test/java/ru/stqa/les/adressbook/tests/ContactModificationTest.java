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
public class ContactModificationTest extends TestBase {

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
   public void testContactModification() {

      Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData().withId(modifiedContact.getId())
              .withName("oleg").withLastname("ivanov").withCity("Moscow")
              .withHomePhone("89996663322").withEmail("test@test.ru");
      app.contact().modifyContact(contact);
      assertEquals(app.contact().count(), before.size());
      Contacts after = app.contact().all();


      //assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
      contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
      assertThat(after, equalTo(before.withAdded(contact)));

   }

}
