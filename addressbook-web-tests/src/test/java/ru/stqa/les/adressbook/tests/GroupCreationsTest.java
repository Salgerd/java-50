package ru.stqa.les.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;
import ru.stqa.les.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationsTest extends TestBase {

   @Test
   public void testGroupCreation() {

      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("testgroup2");
      app.group().create(group);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size() + 1));


      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

   }

}
