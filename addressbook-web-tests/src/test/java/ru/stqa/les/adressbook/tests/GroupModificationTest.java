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
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
         app.group().create(new GroupData().withName("testgroup1"));
      }
   }

   @Test
   public void testGroupModification () {

      Groups before = app.group().all();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modifiedGroup.getId()).withName("testgroup2").withHeader("test1").withFooter("test2");
      app.group().modifyGroup(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.group().all();

      assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


   }



}
