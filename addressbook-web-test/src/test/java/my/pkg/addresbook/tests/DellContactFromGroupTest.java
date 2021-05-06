package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class DellContactFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));

        }
        if (app.db().contactsInGroup().size() == 0){
            app.goTo().goToHomePage();
            app.contact().addToGroup(app.db().contacts().iterator().next());
        }
    }


    @Test(enabled = true)
    public void testDellContactFromGroup() throws Exception {

        Contacts before = app.db().contactsInGroup();
        app.goTo().goToHomePage();
        ContactData contact = before.iterator().next();
        GroupData group = contact.getGroups().iterator().next();
         app.contact().dellFromGroup(contact, group);
        Contacts after = app.db().contacts();
        assertTrue(after.iterator().next().getGroups().isEmpty());

    }
}
