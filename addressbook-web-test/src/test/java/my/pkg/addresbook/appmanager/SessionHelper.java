package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String login, String password, String url) {
    wd.get(url);
    ClickChangeElemText(By.name("user"), login);
    NoClickChangeElemText(By.name("pass"), password);
    clickElem(By.xpath("//input[@value='Login']"));
    }
}
