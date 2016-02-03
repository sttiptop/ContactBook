package service;

import dao.ContactDao;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yevgeni on 28.01.2016.
 */

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Transactional

    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Transactional

    public List<Contact> getAllContact() {
        return contactDao.getAllContact();
    }

    @Transactional

    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);

    }

    @Transactional
    public Contact getContact(int id) {
        return contactDao.getContact(id);
    }

    @Transactional
    public void saveChanges(Contact contact) {
        contactDao.saveChanges(contact);
    }
}
