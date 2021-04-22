package my.pkg.addresbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import my.pkg.addresbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contacts count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "File format")
    public String format;

    public static void main(String[] args) throws IOException {

        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if  (format.equals("json")){
            saveAsJSON(contacts, new File(file));
        }else System.out.println("Не поддерживается формат" + format);
    }

    private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }


    private List<ContactData> generateContacts(int count) {
        String photo = new File("src/test/resources/23.jpg").getAbsolutePath();
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withName(String.format("name %s", i))
                    .withLastName(String.format("lastName %s", i))
                    .withMiddleName(String.format("middleName %s", i))
                    .withPhoto(photo)
                    .withHomePhone(String.valueOf(1234 * (i + 1))).withMobilePhone(String.valueOf(2345 * (i + 1))).withWorkPhone(String.valueOf(3456 * (i + 1)))
                    .withEmail(String.format("%s@123.ru", 123 * (i + 1))).withEmail2(String.format("%s@123.ru", 234 * (i + 1))).withEmail3(String.format("%s@123.ru", 345 * (i + 1)))
                    .withAddress(String.format("Test testo test %s  \n 2 string \n 3 string", i)));


        }
        return contacts;
    }
}
