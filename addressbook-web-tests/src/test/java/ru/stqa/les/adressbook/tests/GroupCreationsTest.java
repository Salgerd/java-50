package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {

      app.goTo().groupPage();
      Set<GroupData> before = app.group().all();
      GroupData group = new GroupData().withName("testgroup2");
      app.group().create(group);
      Set<GroupData> after = app.group().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
      before.add(group);
      Assert.assertEquals(before, after);

   }

}
