package my.pkg.addresbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    app.wd.findElement(By.linkText("group page")).click();

  }

}
