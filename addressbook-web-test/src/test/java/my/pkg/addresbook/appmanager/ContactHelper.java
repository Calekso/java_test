package my.pkg.addresbook.appmanager;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactData(ContactData contactData) {

        ClickChangeElemText(By.name("firstname"), contactData.getFirstName());
        ClickChangeElemText(By.name("middlename"), contactData.getMiddleName());
        NoClickChangeElemText(By.name("lastname"), contactData.getLastName());

        clickElem(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillModifyContactData(ContactData contactData) {
        ClickChangeElemText(By.name("firstname"), contactData.getFirstName());
        ClickChangeElemText(By.name("middlename"), contactData.getMiddleName());
        NoClickChangeElemText(By.name("lastname"), contactData.getLastName());

    }

    public void initModifyContact(int index) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + index + "']")).click();
    }

    public void submitModifyContact() {
        clickElem(By.name("update"));
    }

    public void ChoseContact(int index) {
        wd.findElement(By.xpath("//input[@id=" + index + "]")).click();
    }

    public void DeleteSelectedContact() {
        clickElem(By.xpath("//input[@value='Delete']"));
    }

    public void delete(ContactData contact) {
        ChoseContact(contact.getId());
        DeleteSelectedContact();
        ConfirmContactDel();
        NavigationHelper.goToHomePage();
    }

    public void modify(ContactData modifiedContact) {
        initModifyContact(modifiedContact.getId());
        fillModifyContactData(modifiedContact);
        submitModifyContact();
        wd.findElement(By.linkText("home page")).click();
    }

    public void ConfirmContactDel() {
        wd.switchTo().alert().accept();
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
        for (WebElement element : elements) {
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withLastName(lastName).withName(name).withMiddleName(null);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastName = element.findElements(By.tagName("td")).get(1).getText();

            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            String allEmails = element.findElements(By.tagName("td")).get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAllPhones(allPhones)
                    .withAllEmails(allEmails);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initModifyContact(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);

    }
}
