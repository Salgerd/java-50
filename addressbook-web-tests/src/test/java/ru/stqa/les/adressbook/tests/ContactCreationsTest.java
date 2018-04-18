package ru.stqa.les.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationsTest extends TestBase {

    @Test
    public void testContactCreation() {

       Contacts before = app.contact().all();
       ContactData contact = new ContactData()
               .withName("oleg").withLastname("ivanov").withCity("Moscow")
               .withTelephone("89996663322").withEmail("test@test.ru");
       app.contact().create(contact);
       Contacts after = app.contact().all();
       assertEquals(after.size(), before.size() + 1);

       assertThat(after, equalTo(
               before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
