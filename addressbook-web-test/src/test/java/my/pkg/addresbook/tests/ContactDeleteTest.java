package my.pkg.addresbook.tests;

import my.pkg.addresbook.model.ContactData;
import my.pkg.addresbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeleteTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3"));
    }}

  @Test (enabled = true)
  public void testContactDelete() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);

    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.Without(deletedContact)));
  }


}
