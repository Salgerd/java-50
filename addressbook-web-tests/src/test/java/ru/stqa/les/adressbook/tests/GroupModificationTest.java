package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupModificationTest extends TestBase {

   @Test
   public void testGroupModification () {

      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();
      if (! app.getGroupHelper().isThereAGroup()) {
         app.getGroupHelper().createGroup(new GroupData("testgroup1", "null", "test2"));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testgroup1", "test1", "test2"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      int after = app.getGroupHelper().getGroupCount();

   }
}
