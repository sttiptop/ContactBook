package dao;

import model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevgeni on 28.01.2016.
 */
@Repository
public class ContactDaoImpl implements ContactDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
    @SuppressWarnings("unchecked")

    public List<Contact> getAllContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact ").list();

    }


    public void deleteContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    public Contact getContact(int id) {
        //Query query=sessionFactory.getCurrentSession().createQuery("from Contact where id=?");
        //query.setInteger(0,id);
        //Contact contact= (Contact)sessionFactory.getCurrentSession().load(Contact.class,id);
        //contact.setEmails(sessionFactory.getCurrentSession().);
        return (Contact)sessionFactory.getCurrentSession().get(Contact.class,id);

    }

    public void saveChanges(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }
}
