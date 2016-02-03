package service;

import dao.PhoneDao;
import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    PhoneDao phoneDao;

    @Transactional
    public void addPhone(Phone phone) {
        phoneDao.addPhone(phone);

    }

    @Transactional
    public void saveChanges(Phone phone) {
        phoneDao.saveChanges(phone);
    }

    @Transactional
    public void deletePhone(Phone phone) {
        phoneDao.deletePhone(phone);
    }

    @Transactional
    public List<Phone> getContactPhones(int id) {
        return phoneDao.getContactPhones(id);
    }
}
