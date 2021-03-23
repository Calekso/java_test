package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().GroupCount();
    //проверяем есть ли группа для удаления и создаем ее если нет
    if (! app.getGroupHelper().isGroupThere()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    app.wd.findElement(By.linkText("group page")).click();
    int after = app.getGroupHelper().GroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
