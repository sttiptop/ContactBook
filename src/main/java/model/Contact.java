package model;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Entity
public class Contact {
    private int contactId;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String firstname;
    private String secondname;
    private String address;
    private Date birthday;
    private Set<Email> Emails = new HashSet<Email>(0);
    private Set<Phone> phones = new HashSet<Phone>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id", nullable = false)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "contact",targetEntity = Email.class,fetch = FetchType.EAGER)
    public Set<Email> getEmails() {
        return Emails;
    }

    public void setEmails(Set<Email> emails) {
        Emails = emails;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "contact",targetEntity = Phone.class,fetch = FetchType.EAGER)
    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 40)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 40)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "secondname", nullable = false, length = 40)
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 40)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactId != contact.contactId) return false;
        if (surname != null ? !surname.equals(contact.surname) : contact.surname != null) return false;
        if (firstname != null ? !firstname.equals(contact.firstname) : contact.firstname != null) return false;
        if (secondname != null ? !secondname.equals(contact.secondname) : contact.secondname != null) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        if (birthday != null ? !birthday.equals(contact.birthday) : contact.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
