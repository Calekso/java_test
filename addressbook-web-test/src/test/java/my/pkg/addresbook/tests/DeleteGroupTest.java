package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class DeleteGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("test1", null, "test3"));
    }
  }

  @Test
  public void testDeleteGroup() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), index);//сравнить размер списков

    before.remove(index);
    Assert.assertEquals(before, after);//сравнить списки групп по названию

  }



}
