package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {

      app.goTo().groupPage();
      List<GroupData> before = app.group().list();
      GroupData group = new GroupData("testgroup2", "null", "test2");
      app.group().create(group);
      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }

}
