package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {
      app.gotoGroupPage();
      app.initGroupCreation();
      app.fillGroupForm(new GroupData("testgroup1", "test1", "test2"));
      app.submitGroupCreation();
      app.returnToGroupPage();
   }

}
