package ru.stqa.les.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
=======
import java.util.HashSet;
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
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

<<<<<<< HEAD
      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      GroupData group = new GroupData()
              .withId(before.get(index).getId()).withName("testgroup2").withHeader("test1").withFooter("test2");
      app.group().modify(group);
      List<GroupData> after = app.group().list();
=======
      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
         app.getGroupHelper().createGroup(new GroupData("testgroup1", "null", "test2"));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      GroupData group = new GroupData(before.get(before.size() - 1).getId(),"testgroup1", "test1", "test2");
      app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

   }

}
