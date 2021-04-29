package my.pkg.addresbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import my.pkg.addresbook.model.GroupData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateContactTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(enabled = true, dataProvider = "validContactsFromJSON")
    public void testContactCreation(ContactData newContact) throws Exception {
        Contacts before = app.db().contacts();
        app.goTo().goToContactAddPage();
        app.contact().fillContactData(newContact);
        app.goTo().goToHomePage();
        Contacts after = app.db().contacts();
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
