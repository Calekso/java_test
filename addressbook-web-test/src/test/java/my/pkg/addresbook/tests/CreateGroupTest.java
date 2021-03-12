package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.GroupData;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGoupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupForm();
    app.getNavigationHelper().goToGroupPage();
  }

}
