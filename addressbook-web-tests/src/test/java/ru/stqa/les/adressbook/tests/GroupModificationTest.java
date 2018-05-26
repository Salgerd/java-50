package ru.stqa.les.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;
import ru.stqa.les.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("testgroup1"));
      }
   }

   @Test
   public void testGroupModification () {

      Groups before = app.db().groups();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modifiedGroup.getId()).withName("testgroup2").withHeader("test1").withFooter("test2");
      app.goTo().groupPage();
      app.group().modifyGroup(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.db().groups();

      assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


   }



}
