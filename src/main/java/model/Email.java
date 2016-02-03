package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


/**
 * Created by Yevgeni on 01.02.2016.
 */
@Entity
public class Email {
    private int emailId;
    @NotEmpty
    @org.hibernate.validator.constraints.Email()
    private String email;
    @NotEmpty
    private String kind;

    public Email(int emailId,Contact contact,String typeEmail, String email){
        this.emailId=emailId;
        this.contact = contact;
        this.kind = typeEmail;
        this.email = email;
    }
    public Email(Contact contact, String typeEmail, String email) {
        this.contact = contact;
        this.kind = typeEmail;
        this.email = email;
    }

    public Email() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Email_id", nullable = false)
    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "kind", nullable = false, length = 40)
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;

        if (emailId != email1.emailId) return false;
        if (email != null ? !email.equals(email1.email) : email1.email != null) return false;
        if (kind != null ? !kind.equals(email1.kind) : email1.kind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        return result;
    }

    private Contact contact;
    @ManyToOne(targetEntity = Contact.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contacts) {
        this.contact = contacts;
    }
}
