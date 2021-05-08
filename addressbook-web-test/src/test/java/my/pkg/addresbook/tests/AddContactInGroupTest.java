package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactInGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withName("test1")
                    .withLastName("test2")
                    .withMiddleName("test3"));
            app.goTo().goToHomePage();
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            app.goTo().goToHomePage();

        }
        if (app.contact().сontactWithoutGroup(app.db().contacts()) == null) {
            app.contact().createContact(new ContactData()
                    .withName("test1")
                    .withLastName("test2")
                    .withMiddleName("test3"));
            app.goTo().goToHomePage();
        }
    }


    @Test(enabled = true)
    public void testAddContactInGroup() throws Exception {
        Contacts before = app.db().contacts();
        app.goTo().goToHomePage();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        ContactData contact =  app.contact().сontactWithoutGroup(before);
        ContactData contactAddedGroup = contact.inGroup(group);

        app.contact().addToGroup(contactAddedGroup, group);

        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));

        Contacts contacts_after = app.db().getContactById(contact.getId());
        ContactData contactWithGroup = contacts_after.iterator().next();
        assertThat(contactWithGroup, CoreMatchers.equalTo(contactAddedGroup));
    }
}
