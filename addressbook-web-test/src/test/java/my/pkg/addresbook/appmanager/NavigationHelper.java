package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd)  {
    super(wd);
  }

  public void goToHomePage() {clickElem(By.linkText("home"));
  }

  public void goToContactAddPage() {clickElem(By.linkText("add new"));
  }

  public void groupPage() { clickElem(By.linkText("groups"));
  }
}
