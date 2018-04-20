package ru.stqa.les.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationsTest extends TestBase {

    @Test
    public void testContactCreation() {

       Contacts before = app.contact().all();
       File photo = new File("src/test/resources/duck.png");
       ContactData contact = new ContactData()
               .withName("oleg").withLastname("ivanov").withCity("Moscow")
<<<<<<< HEAD
               .withHomePhone("89996663322").withMobilePhone("89996663323").withWorkPhone("89996663324")
               .withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru")
               .withAddress("address1").withAddress2("address2").withPhoto(photo);
=======
               .withHomePhone("89996663322").withEmail("test@test.ru");
>>>>>>> parent of e93cc95... Задание №11: Реализовать тест для проверки информации о контактах на главной странице
       app.contact().create(contact);
       assertEquals(app.contact().count(), before.size() + 1);
       Contacts after = app.contact().all();

       assertThat(after, equalTo(
               before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }



}
