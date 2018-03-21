package ru.stqa.les.adressbook;


import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{


    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }


}
