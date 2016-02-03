package dao;

import model.Email;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Repository
public class EmailDaoImpl implements EmailDao {
    @Autowired
    SessionFactory sessionFactory;
    public void addEmail(Email email) {
        sessionFactory.getCurrentSession().save(email);
    }

    public void saveChanges(Email email) {
        sessionFactory.getCurrentSession().update(email);
    }

    public void deleteEmail(Email email) {

    }

    @SuppressWarnings("unchecked")
    public List<Email> getContactEmails(int id) {
        return sessionFactory.getCurrentSession().createQuery("from Email where contact="+id).list();
    }
}
