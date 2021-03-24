package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModifyTest extends TestBase {

  @Test
  public void testModifyGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isGroupThere()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initModifyGroup();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1-modify", "test2-modify", "test3-modify");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitModifyGroupForm();
    app.wd.findElement(By.linkText("group page")).click();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }
}
