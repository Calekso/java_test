package my.pkg.addresbook.tests;

import my.pkg.addresbook.appmanager.ContactHelper;
import my.pkg.addresbook.appmanager.HelperBase;
import my.pkg.addresbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModifyTest extends TestBase{


  @Test (enabled = true)
  public void testContactModify() throws Exception {
    if (! app.getContactHelper().isContactThere()){
      app.getContactHelper().createContact(new ContactData("TestName", "TestMiName", "TestLastName", "TestNick", "Test", "MyComp", "TestAddres", "-", "79991234567", "-", "-", "mail@mail.ru", "-", "-", "-", "9", "July", "2005", "[none]", "unknownAddress", "-", "test"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = HelperBase.randomRange(0, before.size() - 1);
    int id = before.get(index).getId();
    ContactData newContact = new ContactData(before.get(index).getId(),"Mod",  "Mod", "Mod", "Mod",  "Mod",  "Mod", "Mod", "Mod", "79991234567", "-", "-",  "Mod", "-", "-", "-", "9", "July", "2007",  "Mod", "Mod", "-", "Mod");
    app.getContactHelper().initModifyContact(id);
    app.getContactHelper().fillModifyContactData(newContact);
    app.getContactHelper().submitModifyContact();
    app.wd.findElement(By.linkText("home page")).click();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(newContact);
    Comparator<ContactData> byNameLastName = new ContactHelper.LastNameComparator().thenComparing(new ContactHelper.NameComparator());
    before.sort(byNameLastName);
    after.sort(byNameLastName);
    Assert.assertEquals(after, before);
  }
}
