package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModifyTest extends TestBase{


  @Test
  public void testContactModify() throws Exception {
    app.getContactHelper().initModifyContact();
    app.getContactHelper().fillModifyContactData(new ContactData("Mod",  "Mod", "Mod", "Mod",  "Mod",  "Mod", "Mod", "Mod", "79991234567", "-", "-",  "Mod", "-", "-", "-", "9", "July", "2007",  "Mod", "Mod", "-", "Mod"));
    app.getContactHelper().submitModifyContact();
    app.wd.findElement(By.linkText("home page")).click();
  }
}
