package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModifyTest extends TestBase {


    @Test(enabled = true)
    public void testContactModify() throws Exception {
        if (!app.contact().isContactThere()) {
            app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3"));
        }
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withLastName("mod1").withName("mod2");
        app.contact().modify(contact);

        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.Without(modifiedContact).WithAdded(contact)));
    }


}
