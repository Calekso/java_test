package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().goToContactAddPage();
    app.getContactHelper().fillContactData(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "test1", "unknownAddress", "-", "test"));
    app.getNavigationHelper().goToHomePage();
  }

}
