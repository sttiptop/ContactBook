package validator;

import model.Contact;
import model.Email;
import org.hibernate.validator.constraints.impl.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Yevgeni on 03.02.2016.
 */
@Component
public class ContactValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Contact.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Contact contact = (Contact) o;
        EmailValidator emailValidator;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "surname.empty", "surname must not be empty.");
        String username = contact.getSurname();
        if ((username.length()) > 16) {
            errors.rejectValue("surname", "surname.tooLong", "surname must not more than 16 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(contact.getFirstname()).equals(contact
                .getFirstname())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Email not found","Email can't null");
        for(Email email:contact.getEmails()) {
            //if ( !emailValidator.isValid(email.getEmail()))
        }
    }
}
