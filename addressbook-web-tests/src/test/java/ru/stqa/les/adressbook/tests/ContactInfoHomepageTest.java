package ru.stqa.les.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by a.zelenskaya on 20.04.2018.
 */
public class ContactInfoHomepageTest extends TestBase{

   @BeforeMethod
   public void ensurePreconditions() {
            app.goTo().gotoHomePage();
            if (app.contact().all().size() == 0) {
                  app.contact().create(new ContactData()
                                  .withName("oleg").withLastname("ivanov").withCity("Moscow")
                                  .withHomePhone("89996663322").withMobilePhone("89996663323").withWorkPhone("89996663324")
                                  .withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru")
                                  .withAddress("address1").withAddress2("address2"));
               }
         }

   @Test
   public void testContactInfoHomePage() {

            ContactData contact = app.contact().all().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

            assertThat(contact.getAllAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
            assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
            assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

                 }
   private String mergePhones(ContactData contact) {
            return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                            .stream().filter((s) -> !s.equals(""))
                            .map(ContactPhoneTest::cleaned)
                            .collect(Collectors.joining("\n"));
         }

           private String mergeEmails(ContactData contact) {
            return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
                            .stream().filter((s) -> !s.equals(""))
                            .collect(Collectors.joining("\n"));
         }

           public static String cleanedAddress(String field) {
            return field.replaceAll("^\\s+|\\s+$", "")
                            .replaceAll(" +\\n", "\n")
                            .replaceAll("\\n +", "\n")
                            .replaceAll("\\s{2,}", " ");
         }

           public static String cleaned(String field) {

                    return field.replaceAll("\\s", "").replaceAll("[-()]", "");
         }


}
