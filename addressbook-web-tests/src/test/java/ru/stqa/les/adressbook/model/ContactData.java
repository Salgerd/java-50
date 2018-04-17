package ru.stqa.les.adressbook.model;

public class ContactData {
<<<<<<< HEAD
   private int id = Integer.MAX_VALUE;
   private String name;
   private String lastname;
   private String city;
   private String telephone;
   private String email;


   public int getId() { return id;  }
=======
   private final String name;
   private final String lastname;
   private final String city;
   private final String telephone;
   private final String email;


   public ContactData(String name, String lastname, String city, String telephone, String email) {
      this.name = name;
      this.lastname = lastname;
      this.city = city;
      this.telephone = telephone;
      this.email = email;

   }
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)

   public String getName() {
      return name;
   }

   public String getLastname() {
      return lastname;
   }

   public String getCity() {
      return city;
   }

   public String getTelephone() {
      return telephone;
   }

   public String getEmail() {
      return email;
   }

<<<<<<< HEAD
   public ContactData withId(int id) {

      this.id = id;
      return this;
   }

   public ContactData withName(String name) {
      this.name = name;
      return this;
   }

   public ContactData withLastname(String lastname) {
      this.lastname = lastname;
      return this;
   }

   public ContactData withCity(String city) {
      this.city = city;
      return this;
   }

   public ContactData withTelephone(String telephone) {
      this.telephone = telephone;
      return this;
   }

   public ContactData withEmail(String email) {
      this.email = email;
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (name != null ? !name.equals(that.name) : that.name != null) return false;
      return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
   }

   @Override
   public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "ContactData{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", lastname='" + lastname + '\'' +
              '}';
   }
=======
>>>>>>> parent of 029e6ef... Реализация проверок путем сравнения списков (з №9)
}
