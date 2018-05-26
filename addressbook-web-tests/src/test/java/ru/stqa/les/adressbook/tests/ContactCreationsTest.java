package ru.stqa.les.adressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.les.adressbook.model.ContactData;
import ru.stqa.les.adressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationsTest extends TestBase {

   @DataProvider    // если читаем из csv
   public Iterator<Object[]> validContactsFromCsv() throws IOException {
      List<Object[]> list = new ArrayList<Object[]>();
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
         String line = reader.readLine();
         while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new ContactData()
                    .withName(split[0])
                    .withLastname(split[1])
                    .withHomePhone(split[2])
                    .withMobilePhone(split[3])
                    .withWorkPhone(split[4])
                    .withEmail1(split[5])
                    .withEmail2(split[6])
                    .withEmail3(split[7])
                    .withAddress(split[8])
                    .withAddress2(split[9])});
            line = reader.readLine();
         }
         return list.iterator();
      }
   }

   @DataProvider     // если читаем из xml
   public Iterator<Object[]> validContactsFromXml() throws IOException {
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
         String xml = "";
         String line = reader.readLine();
         while (line != null) {
            xml += line;
            line = reader.readLine();
         }
         XStream xstream = new XStream();
         xstream.processAnnotations(ContactData.class);
         List <ContactData> contacts = (List <ContactData>) xstream.fromXML(xml);
         return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
      }
   }

   @DataProvider     // если читаем из json
   public Iterator<Object[]> validContactsFromJson() throws IOException {
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
         String json = "";
         String line = reader.readLine();
         while (line != null) {
            json += line;
            line = reader.readLine();
         }
         Gson gson = new Gson();
         List <ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); // List<ContactData>.class
         return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
      }
   }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) {

       Contacts before = app.contact().all();
       app.contact().create(contact);

       Contacts after = app.contact().all();

       assertEquals(app.contact().count(), before.size() + 1);

       assertThat(after, equalTo(
               before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
