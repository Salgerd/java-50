package ru.stqa.les.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;


public class ContactCreationsTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactHelper().fillContactForm(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
        app.getContactHelper().submitForm();
        app.getNavigationHelper().returnToHomePage();
    }


}