package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    //проверяем есть ли группа для удаления и создаем ее если нет
    if (! app.getGroupHelper().isGroupThere()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    app.wd.findElement(By.linkText("group page")).click();

  }

}