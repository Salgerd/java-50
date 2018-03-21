package ru.stqa.les.adressbook;


import org.testng.annotations.Test;



public class ContactCreationsTest extends TestBase{

    @Test
    public void testContactCreation() {
        gotoAddNewPage();
        fillContactForm();
        submitForm();
        returnToHomePage();
    }


}
