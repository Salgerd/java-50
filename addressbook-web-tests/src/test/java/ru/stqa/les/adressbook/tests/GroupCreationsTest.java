package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {

      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().createGroup(new GroupData("testgroup1", "null", "test2"));
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before+1);
   }

}
