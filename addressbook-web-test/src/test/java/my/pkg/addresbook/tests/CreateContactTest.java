package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateContactTest extends TestBase {


    @Test(enabled = true)
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        app.goTo().goToContactAddPage();
        File photo = new File("src/test/resources/23.jpg");
        ContactData newContact = new ContactData().withName("test1").withLastName("test2").withMiddleName("test3").withPhoto(photo);
        app.contact().fillContactData(newContact);
        app.goTo().goToHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.WithAdded(newContact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void currentDirTest() {
        File currentDir = new File("");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/23.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
