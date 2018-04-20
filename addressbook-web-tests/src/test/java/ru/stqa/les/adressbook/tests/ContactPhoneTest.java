package ru.stqa.les.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
                 .withHomePhone("89996663322").withMobilePhone("222").withWorkPhone("333").withEmail("test@test.ru"));
      }
   }
   @Test
   public void testContactPhone() {
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
   }

   private String mergePhones(ContactData contact) {
      return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
              .stream().filter((s) -> ! s.equals(""))
              .map(ContactPhoneTest::cleaned)
              .collect(Collectors.joining("\n"));
   }

   public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "").replaceAll("[-()]","");
   }
}
