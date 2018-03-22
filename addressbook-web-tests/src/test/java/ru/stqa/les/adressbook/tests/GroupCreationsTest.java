package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().createGroup(new GroupData("testgroup1", "null", "test2"));
   }

}
