package ru.stqa.les.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.les.adressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.zelenskaya on 20.04.2018.
 */
public class ContactDataGenerator {

   @Parameter(names = "-c", description = "Contact count")
   public int count;

   @Parameter(names = "-f", description = "Target file")
   public String file;


   public static void main(String[] args) throws IOException {
      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander jCommander = new JCommander(generator);
      try {
         jCommander.parse(args);
      } catch (ParameterException ex) {
         jCommander.usage();
         return;
      }
      generator.run();
   }

   private void run() throws IOException {
      List<ContactData> contacts = generateContacts(count);
      save(contacts, new File(file));
   }

   private  List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<ContactData>();
      for (int i =0; i < count; i++) {
         contacts.add(new ContactData().withName(String.format("oleg %s", i))
                 .withLastname(String.format("ivanov %s", i))
                 .withCity(String.format("Moscow %s", i))
                 .withHomePhone(String.format("89996663322 %s", i))
                 .withMobilePhone(String.format("89996663323%s", i))
                 .withWorkPhone(String.format("89996663324%s", i))
                 .withEmail1(String.format("test@test.ru%s", i))
                 .withEmail2(String.format("test2@test.ru%s", i))
                 .withEmail3(String.format("test3@test.ru%s", i))
                 .withAddress(String.format("address1%s", i))
                 .withAddress2(String.format("address2")));
      }
      return contacts;
   }

   private  void save(List<ContactData> contacts, File file) throws IOException {
      Writer writer = new FileWriter(file);
      for (ContactData contact: contacts) {
         writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getName(),
                 contact.getLastname(), contact.getCity(),
                 contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone()
                 ,contact.getEmail1(),contact.getEmail2(),contact.getEmail3()
                 ,contact.getAddress(),contact.getAddress2()));
      }
      writer.close();
   }
}
