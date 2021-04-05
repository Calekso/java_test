package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeleteTest extends TestBase{


  @Test (enabled = true)
  public void testContactDelete() throws Exception {
    if (! app.contact().isContactThere()){
      app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3"));
    }
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);

    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.Without(deletedContact)));
  }


}
