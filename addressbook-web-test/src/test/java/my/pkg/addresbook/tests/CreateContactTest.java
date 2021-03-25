package my.pkg.addresbook.tests;

import my.pkg.addresbook.appmanager.ContactHelper;
import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class CreateContactTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToContactAddPage();
    ContactData newContact = new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "[none]", "unknownAddress", "-", "test");
    app.getContactHelper().fillContactData(newContact);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(newContact);
    Comparator<ContactData> byNameLastName = new ContactHelper.LastNameComparator().thenComparing(new ContactHelper.NameComparator());
    before.sort(byNameLastName);
    after.sort(byNameLastName);
    Assert.assertEquals(before, after);

  }

}
