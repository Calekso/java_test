package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().GroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", null, "test3"));
    app.getGroupHelper().submitGroupForm();
    app.getNavigationHelper().goToGroupPage();
    int after = app.getGroupHelper().GroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
