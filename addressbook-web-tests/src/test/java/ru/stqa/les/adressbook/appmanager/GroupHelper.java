package ru.stqa.les.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.les.adressbook.model.GroupData;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class GroupHelper extends HelperBase{

   public GroupHelper(FirefoxDriver wd) {
      super(wd);

   }

   public void returnToGroupPage() {
      click(By.linkText("group page"));
   }

   public void submitGroupCreation() {
      click(By.name("submit"));
   }

   public void fillGroupForm(GroupData groupData) {
      type(By.name("group_name"), groupData.getName());
      type(By.name("group_header"), groupData.getHeader());
      type(By.name("group_footer"), groupData.getFooter());
   }

   public void initGroupCreation() {
      click(By.name("new"));
   }

   public void deleteSelectedGroups() {
      click(By.xpath("//div[@id='content']/form/input[5]"));
   }

   public void selectGroup() {
      click(By.name("selected[]"));
   }

   public void initGroupModification() {
      click(By.name("edit"));
   }

   public void submitGroupModification() { click(By.name("update"));
   }
}
