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

  public void initGroupCreation() {
    clickElem(By.name("new"));
  }



  public void deleteSelectGroup() {
    clickElem(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initModifyGroup() { clickElem(By.name("edit"));

  }

  public void submitModifyGroupForm() {clickElem(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(new GroupData("test1", null, "test3"));
    submitGroupForm();
    clickElem(By.linkText("groups"));
  }

  public boolean isGroupThere() {
     return isElementPresent(By.name("selected[]"));
  }

    public int GroupCount() {
      return wd.findElements(By.name("selected[]")).size();
    }
}
