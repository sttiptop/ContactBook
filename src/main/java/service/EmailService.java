package service;

import model.Email;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
public interface EmailService {
    void addEmail(Email email);

    void saveChanges(Email email);

    void deleteEmail(Email email);
    List<Email> getContactEmails(int id);
}
