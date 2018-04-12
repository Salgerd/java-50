package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.List;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupModificationTest extends TestBase {

   @Test
   public void testGroupModification () {

      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
         app.getGroupHelper().createGroup(new GroupData("testgroup1", "null", "test2"));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testgroup1", "test1", "test2"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

   }
}
