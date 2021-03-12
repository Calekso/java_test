package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.GroupData;
import org.testng.annotations.Test;

public class CreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGoupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupForm();
    app.getNavigationHelper().goToGroupPage();
  }

  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().goToContactAddPage();
    app.fillContactData(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "test1", "unknownAddress", "-", "test"));
    app.getNavigationHelper().goToHomePage();
  }

}
