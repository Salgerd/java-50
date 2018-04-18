package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
         app.group().create(new GroupData().withName("testgroup1"));
      }
   }

   @Test
   public void testGroupModification () {

      Set<GroupData> before = app.group().all();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modifiedGroup.getId()).withName("testgroup2").withHeader("test1").withFooter("test2");
      app.group().modifyGroup(group);
      Set<GroupData> after = app.group().all();
      Assert.assertEquals(after.size(), before.size());

      before.remove(modifiedGroup);
      before.add(group);
      Assert.assertEquals(before, after);

   }



}
