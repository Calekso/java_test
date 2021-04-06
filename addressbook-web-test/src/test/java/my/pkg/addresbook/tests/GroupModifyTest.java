package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModifyTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testModifyGroup() throws Exception {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test2-mod").withFooter("test3-mod").withHeader("test4-mod");
    app.group().modify(group);
    app.wd.findElement(By.linkText("group page")).click();
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before.Without(modifiedGroup).WithAdded(group)));
  }


}
