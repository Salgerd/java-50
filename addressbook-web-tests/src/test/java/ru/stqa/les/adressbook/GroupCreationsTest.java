package ru.stqa.les.adressbook;

import org.testng.annotations.Test;

public class GroupCreationsTest extends TestBase{

   @Test
   public void testGroupCreation() {
      gotoGroupPage();
      initGroupCreation();
      fillGroupForm(new GroupData("testgroup1", "test1", "test2"));
      submitGroupCreation();
      returnToGroupPage();
   }

}
