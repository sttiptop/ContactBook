package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Entity
public class Phone {
    private int phoneId;
    @NotEmpty(message = "will be not empty")
    private String phone;
    private String kind;

    public Phone(int id,Contact contact,String phone, String kind){
        this.contact = contact;
        this.phoneId=id;
        this.phone = phone;
        this.kind = kind;
    }
    public Phone(Contact contact, String phone, String kind) {
        this.contact = contact;
        this.phone = phone;
        this.kind = kind;
    }

    public Phone() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_id", nullable = false)
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 40)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        Phone phone1 = (Phone) o;

        if (phoneId != phone1.phoneId) return false;
        if (phone != null ? !phone.equals(phone1.phone) : phone1.phone != null) return false;
        if (kind != null ? !kind.equals(phone1.kind) : phone1.kind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneId;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        return result;
    }

    private Contact contact;

    @ManyToOne(targetEntity = Contact.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
