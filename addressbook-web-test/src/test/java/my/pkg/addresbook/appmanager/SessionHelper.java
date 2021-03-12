package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String login, String password) {
    wd.get("http://localhost/addressbook/");
    ClickChangeElemText(By.name("user"), login);
    NoClickChangeElemText(By.name("pass"), password);
    clickElem(By.xpath("//input[@value='Login']"));
    }
}
