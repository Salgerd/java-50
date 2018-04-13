package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
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
      GroupData group = new GroupData(before.get(before.size() - 1).getId(),"testgroup2", "test1", "test2");
      app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }
}
