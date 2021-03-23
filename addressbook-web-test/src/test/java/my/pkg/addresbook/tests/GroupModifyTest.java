package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModifyTest extends TestBase {

  @Test
  public void testModifyGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().GroupCount();
    if (! app.getGroupHelper().isGroupThere()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test1-modify", "test2-modify", "test3-modify"));
    app.getGroupHelper().submitModifyGroupForm();
    app.wd.findElement(By.linkText("group page")).click();
    int after = app.getGroupHelper().GroupCount();
    Assert.assertEquals(after, before);
  }
}
