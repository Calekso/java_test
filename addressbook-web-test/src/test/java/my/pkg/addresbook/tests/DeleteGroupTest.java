package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class DeleteGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testDeleteGroup() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
     app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);//сравнить размер списков
    assertThat(after, equalTo(before.Without(deletedGroup)));

  }



}
