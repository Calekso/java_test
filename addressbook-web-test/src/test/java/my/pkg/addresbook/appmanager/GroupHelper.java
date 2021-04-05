package my.pkg.addresbook.appmanager;

import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectGroupById(int id) {
    wd.findElement(By.xpath("//input[@value='"+id+"']")).click();
  }

  public void initModifyGroup() { clickElem(By.name("edit"));

  }

  public void submitModifyGroupForm() {clickElem(By.name("update"));
  }


  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupForm();
    clickElem(By.linkText("groups"));
  }


  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initModifyGroup();
    fillGroupForm(group);
    submitModifyGroupForm();
  }


  public boolean isGroupThere() {
     return isElementPresent(By.name("selected[]"));
  }

    public int GroupCount() {
      return wd.findElements(By.name("selected[]")).size();
    }



  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groups.add(group);
    }
    return groups;
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectGroup();
    //переходим по ссылке страницы групп, выведенной после удаления
    wd.findElement(By.linkText("group page")).click();
  }
}
