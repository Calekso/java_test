package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import my.pkg.addresbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModifyTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3"));
        }}

    @Test(enabled = true)
    public void testContactModify() throws Exception {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withLastName("mod1").withName("mod2").withMiddleName("mod3");
        app.contact().modify(contact);

        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.Without(modifiedContact).WithAdded(contact)));
    }


}
