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
import javax.ws.rs.Path;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
//@Path("/chooseOption/contactOperation/")
@Controller
public class ContactOperationController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/chooseOption/contactOperation/Edit{contactId}" ,method = RequestMethod.POST)
    private String saveChanges2(@PathVariable("contactId") Integer id, HttpServletRequest request,Model model) {
        Contact contact = new Contact();
        contact.setContactId(id);
        contact.setSurname(request.getParameter("surname"));
        contact.setFirstname(request.getParameter("firstname"));
        contact.setSecondname(request.getParameter("secondname"));
        contact.setAddress(request.getParameter("address"));
        contact.setBirthday(Date.valueOf(request.getParameter("birthday")));
        System.out.println(request.getParameter("birthday")+"        JSP DATE");
        System.out.println(Date.valueOf(request.getParameter("birthday"))+"        Java DATE");
        Set<Email> emails = new HashSet<Email>(0);
        Set<Phone> phones = new HashSet<Phone>(0);
        int home=Integer.valueOf(request.getParameter("HomePhoneId"));
        int work=Integer.valueOf(request.getParameter("WorkPhoneId"));
        int mobile=Integer.valueOf(request.getParameter("MobilePhoneId"));
        phoneService.saveChanges(new Phone(mobile,contact,request.getParameter("Mobile"),"Mobile"));
        phoneService.saveChanges(new Phone(home,contact, request.getParameter("Home"),"Home"));
        phoneService.saveChanges(new Phone(work,contact, request.getParameter("Work"),"Work"));
        System.out.println("        JSP MOBILE"+request.getParameter("Mobile")+"        JSP MOBILE");
        //contact.setPhones(phones);
        int homeE=Integer.valueOf(request.getParameter("HomeEmailId"));
        int workE=Integer.valueOf(request.getParameter("WorkEmailId"));
        //emails.add(new Email(contact, "Home", request.getParameter("Home")));
        //emails.add(new Email(contact, "Work", request.getParameter("Work")));
        //contact.setEmails(emails);
        emailService.saveChanges(new Email(homeE,contact,"Home",request.getParameter("Home")));
        emailService.saveChanges(new Email(workE,contact,"Work", request.getParameter("Work")));
        contactService.saveChanges(contact);
        return "redirect:/chooseOption";
    }


}
