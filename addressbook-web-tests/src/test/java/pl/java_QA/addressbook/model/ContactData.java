package pl.java_QA.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")

@XStreamAlias("contact")

public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  @Expose
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "address2")
  @Type(type = "text")
  @Expose
  private String address2;

  @Column(name = "mobile")
  @Type(type = "text")
  @Expose
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  @Expose
  private String workPhone;

  @Column(name = "home")
  @Type(type = "text")
  @Expose
  private String homePhone;

  @Transient
  @Expose
  private String allPhones;

  @Column(name = "email")
  @Type(type = "text")
  @Expose
  private String email;

  @Column(name = "email2")
  @Type(type = "text")
  @Expose
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  @Expose
  private String email3;

  @Transient
  @Expose
  private String group;

  @Transient
  @Expose
  private String allEmails;

  @Expose
  @Transient
  private String allAddresses;

  @Transient
  private String allView;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(address2, that.address2) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, address2, mobilePhone, workPhone, homePhone, email, email2, email3);
  }

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);

  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllAddresses() {
    return allAddresses;
  }

  public ContactData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return this;
  }

  public String getAllView() {
    return allView;
  }

  public ContactData withAllView(String allView) {
    this.allView = allView;
    return this;
  }

  public String getAddress2() {
    return address2;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public String getAllPhones() {
    return allPhones;

  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;

  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withtLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }


  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
           // ", address='" + address + '\'' +
           // ", address2='" + address2 + '\'' +
        //    ", mobile='" + mobilePhone + '\'' +
         //   ", work='" + workPhone + '\'' +
        //    ", email='" + email + '\'' +
       //     ", email2='" + email2 + '\'' +
       //     ", email3='" + email3 + '\'' +
        //    ", home='" + homePhone + '\'' +
            '}';
  }


}
