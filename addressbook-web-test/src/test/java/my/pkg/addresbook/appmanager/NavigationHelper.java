package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void goToContactAddPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
