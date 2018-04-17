package ru.stqa.les.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("testgroup1"));
        }
    }

    @Test
    public void testGroupDeletion() {

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(before.size() - 1);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }


}
