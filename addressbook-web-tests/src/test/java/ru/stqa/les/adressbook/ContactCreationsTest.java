package ru.stqa.les.adressbook;


import org.testng.annotations.Test;



public class ContactCreationsTest extends TestBase{

    @Test
    public void testContactCreation() {
        gotoAddNewPage();
        fillContactForm(new ContactData("oleg", "ivanov", "Moscow", "89996663322", "test@test.ru"));
        submitForm();
        returnToHomePage();
    }


}
