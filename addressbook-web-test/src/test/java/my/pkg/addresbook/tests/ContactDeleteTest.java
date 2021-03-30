package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeleteTest extends TestBase{


  @Test (enabled = false)
  public void testContactDelete() throws Exception {
    if (! app.getContactHelper().isContactThere()){
      app.getContactHelper().createContact(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "[none]", "unknownAddress", "-", "test"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().ChoseContact(before.size() - 1);
    app.getContactHelper().DeleteSelectedContact();
    app.getContactHelper().ConfirmContactDel();
    app.goTo().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);//сравнить размер списков

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);//сравнить списки
  }
}
