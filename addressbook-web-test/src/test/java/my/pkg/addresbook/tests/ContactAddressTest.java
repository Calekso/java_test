package my.pkg.addresbook.tests;

        import my.pkg.addresbook.model.ContactData;
        import org.testng.annotations.Test;

        import java.util.Arrays;
        import java.util.stream.Collectors;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.equalTo;
        import static org.hamcrest.Matchers.sameInstance;

public class ContactAddressTest extends TestBase {


    @Test(enabled = true)
    public void testContactAddress() {
        if (!app.contact().isContactThere()) {
            app.contact().createContact(new ContactData().withName("test1").withLastName("test2").withMiddleName("test3")
                    .withHomePhone("1234").withMobilePhone("2345").withWorkPhone("3456")
                    .withEmail("123@123.ru").withEmail2("234@234.ru").withEmail3("345@345.ru")
                    .withAddress("Test testo test \n 2string \n 3 string"));
        }
        app.goTo().goToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(),equalTo(contactInfoFromEditForm.getAddress()));

    }


}
