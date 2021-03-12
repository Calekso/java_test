package my.pkg.addresbook.appmanager;

import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupForm() {
    clickElem(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    ClickChangeElemText(By.name("group_name"), groupData.getGroupName());
    ClickChangeElemText(By.name("group_header"), groupData.getGroupHeader());
    NoClickChangeElemText(By.name("group_footer"), groupData.getGroupFooter());
  }

  public void initGoupCreation() {
    clickElem(By.name("new"));
  }



  public void deleteSelectGroup() {
    clickElem(By.name("delete"));
  }

  public void selectGroup() {
    clickElem(By.name("selected[]"));
  }
}
