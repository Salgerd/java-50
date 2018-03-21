package ru.stqa.les.adressbook;

import org.testng.annotations.Test;

public class GroupCreationsTest extends TestBase{

   @Test
   public void testGroupCreation() {
      app.gotoGroupPage();
      app.initGroupCreation();
      app.fillGroupForm(new GroupData("testgroup1", "test1", "test2"));
      app.submitGroupCreation();
      app.returnToGroupPage();
   }

}
