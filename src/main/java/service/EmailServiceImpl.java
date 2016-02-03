package service;

import dao.EmailDao;
import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailDao emailDao;

    @Transactional
    public void addEmail(Email email) {

    }

    @Transactional
    public void saveChanges(Email email) {

    }

    @Transactional
    public void deleteEmail(Email email) {

    }
    @Transactional
    public List<Email> getContactEmails(int id) {
        return emailDao.getContactEmails(id);
    }
}
