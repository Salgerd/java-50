package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().list().size() == 0) {
         app.group().create(new GroupData().withName("testgroup1"));
      }
   }

   @Test
   public void testGroupModification () {

      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      GroupData group = new GroupData()
              .withId(before.get(index).getId()).withName("testgroup2").withHeader("test1").withFooter("test2");
      //app.group().modify(group);
      app.group().selectGroup(before.size() - 1);
      app.group().initGroupModification();
      app.group().fillGroupForm(group);
      app.group().submitGroupModification();
      app.group().returnToGroupPage();
      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }

}
