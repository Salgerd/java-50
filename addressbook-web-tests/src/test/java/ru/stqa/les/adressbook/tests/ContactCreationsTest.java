package ru.stqa.les.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationsTest extends TestBase {

    @Test
    public void testContactCreation() {

       List<ContactData> before = app.getContactHelper().getContactList();
       ContactData contact = new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru");
       app.getContactHelper().createContact(contact);
       List<ContactData> after = app.getContactHelper().getContactList();
       Assert.assertEquals(after.size(), before.size() + 1);

       before.add(contact);
       Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
       before.sort(byId);
       after.sort(byId);
       Assert.assertEquals(before, after);
    }


}
