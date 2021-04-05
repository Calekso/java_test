package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected static WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public static void clickElem(By locator) {
    wd.findElement(locator).click();
  }

  public void NoClickChangeElemText(By locator, String text) {
    if (text != null) {
      String elementText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(elementText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public void ClickChangeElemText(By locator, String text) {
    clickElem(locator);
    NoClickChangeElemText(locator, text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  //ищем есть ли элемент на странице
  public boolean isElementPresent(By locator){
   try{
     wd.findElement(locator);
     return true;

   }catch (NoSuchElementException ex){
     return false;    }
  }

  public static int randomRange(int start, int end){
    int randomInt = start + (int) (Math.random() * end);
    return randomInt;
  }
}
