package service;

import model.Contact;

import java.util.List;

/**
 * Created by Yevgeni on 28.01.2016.
 */
public interface ContactService {
    void addContact(Contact contact);
    List<Contact> getAllContact();
    void deleteContact(Contact contact);
    Contact getContact(int id);
    void saveChanges(Contact contact);
}
