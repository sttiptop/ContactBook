package service;

import model.Phone;

import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
public interface PhoneService {
    void addPhone(Phone phone);

    void saveChanges(Phone phone);

    void deletePhone(Phone phone);
    List<Phone> getContactPhones(int id);
}
