package my.pkg.addresbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    goToGroupPage();
    selectGroup();
    deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    wd.findElement(By.linkText("group page")).click();

  }

}
