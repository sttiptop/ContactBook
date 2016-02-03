package dao;

import model.Email;
import model.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */

@Repository
public class PhoneDaoImpl implements PhoneDao {

    @Autowired
    SessionFactory sessionFactory;

    public void addPhone(Phone phone) {

    }

    public void saveChanges(Phone phone) {
    sessionFactory.getCurrentSession().update(phone);
    }

    public void deletePhone(Phone phone) {

    }
    @SuppressWarnings("unchecked")
    public List<Phone> getContactPhones(int id) {
        return sessionFactory.getCurrentSession().createQuery("from Phone where contact="+id).list();
    }
}
