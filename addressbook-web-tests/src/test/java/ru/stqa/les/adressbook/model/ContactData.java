package ru.stqa.les.adressbook.model;

public class ContactData {
   private int id = Integer.MAX_VALUE;
   private String name;
   private String lastname;
   private String city;
   private String homephone;
   private String mobilephone;
   private String workphone;
   private String email;
   private String allPhones;
<<<<<<< HEAD
   private String allEmails;
   private String allAddress;

=======
>>>>>>> parent of e93cc95... Задание №11: Реализовать тест для проверки информации о контактах на главной странице


   public int getId() { return id;  }

   public String getName() {
      return name;
   }

   public String getLastname() {
      return lastname;
   }

   public String getCity() {
      return city;
   }

   public String getHomePhone() {
      return homephone;
   }

   public String getMobilePhone() {
      return mobilephone;
   }

   public String getWorkPhone() {
      return workphone;
   }

   public String getEmail() {
      return email;
   }

   public String getAllPhones() { return allPhones;   }

<<<<<<< HEAD
   public String getAllEmails() { return allEmails;   }

   public String getAllAddress() { return allAddress;   }

   public ContactData withAllEmails(String allEmails) {
      this.allEmails = allEmails;
      return this;
      }

   public ContactData withAllAddress(String allAddress) {
      this.allAddress = allAddress;
      return this;
      }

=======
>>>>>>> parent of e93cc95... Задание №11: Реализовать тест для проверки информации о контактах на главной странице
   public ContactData withAllPhones(String allPhones) {

      this.allPhones = allPhones;
      return this;
   }

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

   public ContactData withHomePhone(String homephone) {
      this.homephone = homephone;
      return this;
   }

   public ContactData withMobilePhone(String mobilephone) {
      this.mobilephone = mobilephone;
      return this;
   }

   public ContactData withWorkPhone(String workphone) {
      this.workphone = workphone;
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

      if (id != that.id) return false;
      if (name != null ? !name.equals(that.name) : that.name != null) return false;
      return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (name != null ? name.hashCode() : 0);
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
