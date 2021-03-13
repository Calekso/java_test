package my.pkg.addresbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase{


  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().ChoseContact();
    app.getContactHelper().DeleteSelectedContact();
    app.getContactHelper().ConfirmContactDel();
    app.getNavigationHelper().goToHomePage();
  }
}
