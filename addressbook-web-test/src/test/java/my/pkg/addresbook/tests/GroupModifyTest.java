package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModifyTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
   if (app.db().groups().size() == 0) {
     app.goTo().groupPage();
     app.group().create(new GroupData().withName("test1"));
  }}

  @Test
  public void testModifyGroup() throws Exception {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test2-mod").withFooter("test3-mod").withHeader("test4-mod");
    app.goTo().groupPage();
    app.group().modify(group);
    app.wd.findElement(By.linkText("group page")).click();
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.Without(modifiedGroup).WithAdded(group)));
  verifyGroupListInUI();
  }




}
