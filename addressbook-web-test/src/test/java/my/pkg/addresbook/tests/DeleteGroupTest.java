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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class DeleteGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }}

  @Test
  public void testDeleteGroup() throws Exception {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
     app.group().delete(deletedGroup);
    assertThat(app.group().getGroupCount(), equalTo(before.size() - 1));//сравнить размер списков
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.Without(deletedGroup)));

  }



}
