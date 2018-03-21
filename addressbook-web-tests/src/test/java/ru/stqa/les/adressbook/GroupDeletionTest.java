package ru.stqa.les.adressbook;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTest extends TestBase{


    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }


}
