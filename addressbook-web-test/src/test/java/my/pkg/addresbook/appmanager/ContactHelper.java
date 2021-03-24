package my.pkg.addresbook.appmanager;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactData(ContactData contactData) {

    ClickChangeElemText(By.name("firstname"), contactData.getFirstName());
    ClickChangeElemText(By.name("middlename"), contactData.getMiddleName());
    NoClickChangeElemText(By.name("lastname"), contactData.getLastName());
    NoClickChangeElemText(By.name("nickname"), contactData.getNickName());
    ClickChangeElemText(By.name("title"), contactData.getTitle());
    ClickChangeElemText(By.name("company"), contactData.getCompany());
    ClickChangeElemText(By.name("address"), contactData.getAddress());
    ClickChangeElemText(By.name("home"), contactData.getHomePhone());
    ClickChangeElemText(By.name("mobile"), contactData.getMobilePhone());
    ClickChangeElemText(By.name("work"), contactData.getWorkPhone());
    NoClickChangeElemText(By.name("fax"), contactData.getFax());
    ClickChangeElemText(By.name("email"), contactData.geteMailOne());
    NoClickChangeElemText(By.name("email2"), contactData.geteMailTwo());
    NoClickChangeElemText(By.name("email3"), contactData.geteMailThree());
    NoClickChangeElemText(By.name("homepage"), contactData.getHomePage());
    clickElem(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    clickElem(By.xpath("//option[@value='" + contactData.getBirthDay() + "']"));
    clickElem(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    clickElem(By.xpath("//option[@value='" + contactData.getBirthMonth() + "']"));
    ClickChangeElemText(By.name("byear"), contactData.getBirthYear());
    clickElem(By.name("new_group"));
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
    clickElem(By.xpath("//select/option[text()='" + contactData.getGroupName() + "']"));
    ClickChangeElemText(By.name("address2"), contactData.getAddressTwo());
    ClickChangeElemText(By.name("phone2"), contactData.getPhoneTwo());
    NoClickChangeElemText(By.name("notes"), contactData.getNotes());
    clickElem(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillModifyContactData(ContactData contactData) {
    ClickChangeElemText(By.name("firstname"), contactData.getFirstName());
    ClickChangeElemText(By.name("middlename"), contactData.getMiddleName());
    NoClickChangeElemText(By.name("lastname"), contactData.getLastName());
    NoClickChangeElemText(By.name("nickname"), contactData.getNickName());
    ClickChangeElemText(By.name("title"), contactData.getTitle());
    ClickChangeElemText(By.name("company"), contactData.getCompany());
    ClickChangeElemText(By.name("address"), contactData.getAddress());
    ClickChangeElemText(By.name("home"), contactData.getHomePhone());
    ClickChangeElemText(By.name("mobile"), contactData.getMobilePhone());
    ClickChangeElemText(By.name("work"), contactData.getWorkPhone());
    NoClickChangeElemText(By.name("fax"), contactData.getFax());
    ClickChangeElemText(By.name("email"), contactData.geteMailOne());
    NoClickChangeElemText(By.name("email2"), contactData.geteMailTwo());
    NoClickChangeElemText(By.name("email3"), contactData.geteMailThree());
    NoClickChangeElemText(By.name("homepage"), contactData.getHomePage());
    clickElem(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    clickElem(By.xpath("//option[@value='" + contactData.getBirthDay() + "']"));
    clickElem(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    clickElem(By.xpath("//option[@value='" + contactData.getBirthMonth() + "']"));
    ClickChangeElemText(By.name("byear"), contactData.getBirthYear());
    ClickChangeElemText(By.name("address2"), contactData.getAddressTwo());
    ClickChangeElemText(By.name("phone2"), contactData.getPhoneTwo());
    NoClickChangeElemText(By.name("notes"), contactData.getNotes());
   }

  public void initModifyContact() {
    clickElem(By.xpath("//img[@alt='Edit']"));
  }

  public void submitModifyContact() { clickElem(By.name("update"));
  }

  public void ChoseContact() {clickElem(By.name("selected[]"));

  }

  public void DeleteSelectedContact() {clickElem(By.xpath("//input[@value='Delete']"));
  }


  public void ConfirmContactDel() { wd.switchTo().alert().accept();
  }

  public boolean isContactThere() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    clickElem(By.linkText("add new"));
    fillContactData(contact);
    clickElem(By.linkText("home"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String name = element.findElements(By.tagName("td")).get(2).getText();
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(name, null, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
