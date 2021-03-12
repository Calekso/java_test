package my.pkg.addresbook;

import org.testng.annotations.Test;

public class CreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    goToGroupPage();
    initGoupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupForm();
    goToGroupPage();
  }

  @Test
  public void testContactCreation() throws Exception {

    goToContactAddPage();
    fillContactData(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "test1", "unknownAddress", "-", "test"));
    goToHomePage();
  }

}
