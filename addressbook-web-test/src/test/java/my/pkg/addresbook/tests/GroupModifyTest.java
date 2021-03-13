package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModifyTest extends TestBase {

  @Test
  public void testModifyGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initModifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test1-modify", "test2-modify", "test3-modify"));
    app.getGroupHelper().submitModifyGroupForm();
    app.wd.findElement(By.linkText("group page")).click();
  }
}
