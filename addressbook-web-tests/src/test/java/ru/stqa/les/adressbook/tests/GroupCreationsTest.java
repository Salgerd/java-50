package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
=======
import java.util.HashSet;
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
import java.util.List;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {

<<<<<<< HEAD
      app.goTo().groupPage();
      List<GroupData> before = app.group().list();
      GroupData group = new GroupData().withName("testgroup2");
      app.group().create(group);
      List<GroupData> after = app.group().list();
=======
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      GroupData group = new GroupData("testgroup1", "null", "test2");
      app.getGroupHelper().createGroup(group);
      List<GroupData> after = app.getGroupHelper().getGroupList();
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
      Assert.assertEquals(after.size(), before.size() + 1);


      int max = 0;
      for (GroupData g : after) {
         if (g.getId() > max) {
            max = g.getId();
         }
      }

      group.setId(max);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

   }

}
