package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase{


  @Test
  public void testContactDelete() throws Exception {
    if (! app.getContactHelper().isContactThere()){
      app.getContactHelper().createContact(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "[none]", "unknownAddress", "-", "test"));
    }
    app.getContactHelper().ChoseContact();
    app.getContactHelper().DeleteSelectedContact();
    app.getContactHelper().ConfirmContactDel();
    app.getNavigationHelper().goToHomePage();
  }
}
