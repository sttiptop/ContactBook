package controller;

import model.Contact;
import model.Email;
import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ContactService;
import service.EmailService;
import service.PhoneService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Controller
public class ContactOperationController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PhoneService phoneService;

    /*@RequestMapping(value = "/contactOperation/addContact", method = RequestMethod.POST)
    private String saveContact(Model model,HttpServletRequest request) {
        Contact contact = new Contact();
        contact.setSurname(request.getParameter("surname"));
        contact.setFirstname(request.getParameter("firstname"));
        contact.setSecondname(request.getParameter("secondname"));
        contact.setAddress(request.getParameter("address"));
        contact.setBirthday(Date.valueOf(request.getParameter("birthday")));
        System.out.println(request.getParameter("birthday")+"        JSP DATE");
        System.out.println(Date.valueOf(request.getParameter("birthday"))+"        Java DATE");
        Set<Email> emails = new HashSet<Email>();
        Set<Phone> phones = new HashSet<Phone>();
        phones.add(new Phone(contact, request.getParameter("typePhone"), request.getParameter("phone")));
        contact.setPhones(phones);
        emails.add(new Email(contact, request.getParameter("typeEmail"), request.getParameter("Email")));
        //phone.setKind(request.getParameter("typePhone"));
        // phone.setPhone(request.getParameter("phone"));

        //email.setKind(request.getParameter("typeEmail"));
        //email.setEmail(request.getParameter("Email"));

        contactService.addContact(contact);
        //emailService.addEmail(email);
        //phoneService.addPhone(phone);
        return "redirect:/chooseOption";
    }*/


}
