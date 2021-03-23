package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    //проверяем есть ли группа для удаления и создаем ее если нет
    if (! app.getGroupHelper().isGroupThere()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    app.wd.findElement(By.linkText("group page")).click();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);//сравнить размер списков

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);//сравнить списки групп по названию

  }

}
