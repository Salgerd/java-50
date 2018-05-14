package ru.stqa.les.adressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("contact")
public class ContactData {

   @XStreamOmitField
   private int id = Integer.MAX_VALUE;
   @Expose
   private String name;
   @Expose
   private String lastname;
   @Expose
   private String city;
   @Expose
   private String homephone;
   @Expose
   private String mobilephone;
   @Expose
   private String workphone;
   @Expose
   private String email1;
   @Expose
   private String email2;
   @Expose
   private String email3;
   @Expose
   private String address;
   @Expose
   private String address2;
   @Expose
   private String allPhones;
   @Expose
   private String allEmails;
   @Expose
   private String allAddress;



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

   public String getEmail1() {
      return email1;
   }

   public String getEmail2() {
      return email2;
   }

   public String getEmail3() {
      return email3;
   }

   public String getAddress() {
      return address;
   }

   public String getAddress2() {
      return address2;
   }

   public String getAllPhones() { return allPhones;   }

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

   public ContactData withEmail1(String email1) {
      this.email1 = email1;
      return this;
   }

   public ContactData withEmail2(String email2) {
      this.email2 = email2;
      return this;
   }

   public ContactData withEmail3(String email3) {
      this.email3 = email3;
      return this;
   }

   public ContactData withAddress(String address) {
      this.address = address;
      return this;
   }

   public ContactData withAddress2(String address2) {
      this.address2 = address2;
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
