package ru.stqa.les.adressbook.model;

public class ContactData {
   private int id;
   private final String name;
   private final String lastname;
   private final String city;
   private final String telephone;
   private final String email;


   public ContactData( String name, String lastname, String city, String telephone, String email) {
      this.id = Integer.MAX_VALUE;
      this.name = name;
      this.lastname = lastname;
      this.city = city;
      this.telephone = telephone;
      this.email = email;

   }

   public ContactData(int id, String name, String lastname, String city, String telephone, String email) {
      this.id = id;
      this.name = name;
      this.lastname = lastname;
      this.city = city;
      this.telephone = telephone;
      this.email = email;

   }


   public int getId() { return id;  }

   public void setId(int id) { this.id = id;    }

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
}
