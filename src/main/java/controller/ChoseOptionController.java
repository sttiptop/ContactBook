package controller;

import model.Contact;
import model.Email;
import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ContactService;
import service.EmailService;
import service.PhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yevgeni on 01.02.2016.
 */
@Controller
public class ChoseOptionController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    private String back() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/chooseOption/delete{contactId}")
    private String deleteContact(@PathVariable("contactId") Integer id) {
        Contact contact = contactService.getContact(id);

        contactService.deleteContact(contact);
        return "redirect:/chooseOption";
    }

    @RequestMapping(value = "/chooseOption/contactOperation/Edit{contactId}", method = RequestMethod.GET)
    private String editContact(Model model, @PathVariable("contactId") Integer id) {
        Contact contactEdit = contactService.getContact(id);
        List<Email> emails=emailService.getContactEmails(id);
        List<Phone> phones=phoneService.getContactPhones(id);

        for(Phone phone:phones){
            phone.getPhoneId();
        }
        model.addAttribute("contactEdit", contactEdit);
        model.addAttribute("setEmails", emails);
        model.addAttribute("setPhones", phones);
        return "contactOperation";
    }

    @RequestMapping(value = "/chooseOption/contactOperation", method = RequestMethod.GET)
    private String goTOContactOperation(Model model) {
        Contact contactEdit = null;
        List<Email> emails=null;
        List<Phone> phones=null;
        model.addAttribute("contactEdit", contactEdit);
        model.addAttribute("setEmails", emails);
        model.addAttribute("setPhones", phones);

        return "contactOperation";
    }

    @RequestMapping(value = "/chooseOption/contactOperation/addContact", method = RequestMethod.POST)
    private String saveContact(Model model,HttpServletRequest request) {
        Contact contact = new Contact();
        System.out.println(contact.getContactId()+"        CONTACT ID");
        contact.setSurname(request.getParameter("surname"));
        contact.setFirstname(request.getParameter("firstname"));
        contact.setSecondname(request.getParameter("secondname"));
        contact.setAddress(request.getParameter("address"));
        contact.setBirthday(Date.valueOf(request.getParameter("birthday")));
        Set<Email> emails = new HashSet<Email>(0);
        Set<Phone> phones = new HashSet<Phone>(0);
        System.out.println("        JSP MOBILE"+request.getParameter("mobile")+"        JSP MOBILE");
        phones.add(new Phone(contact, request.getParameter("mobilePhone"), "Mobile"));
        phones.add(new Phone(contact, request.getParameter("homePhone"),"Home"));
        phones.add(new Phone(contact, request.getParameter("workPhone"),"Work"));
        contact.setPhones(phones);
        emails.add(new Email(contact, "Home", request.getParameter("homeEmail")));
        emails.add(new Email(contact, "Work", request.getParameter("workEmail")));
        contact.setEmails(emails);
        //phone.setKind(request.getParameter("typePhone"));
        // phone.setPhone(request.getParameter("phone"));

        //email.setKind(request.getParameter("typeEmail"));
        //email.setEmail(request.getParameter("Email"));

        contactService.addContact(contact);
        //emailService.addEmail(email);
        //phoneService.addPhone(phone);
        return "redirect:/chooseOption";
    }

   /* @RequestMapping(value = "/chooseOption/contactOperation/saveChanges{contactId}" ,method = RequestMethod.POST)
    private String saveChanges(@PathVariable("contactId") Integer id, HttpServletRequest request,Model model) {
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
        int homeE=Integer.valueOf(request.getParameter("HomeIdEmail"));
        int workE=Integer.valueOf(request.getParameter("WorkIdEmail"));
        //emails.add(new Email(contact, "Home", request.getParameter("Home")));
        //emails.add(new Email(contact, "Work", request.getParameter("Work")));
        //contact.setEmails(emails);
        emailService.saveChanges(new Email(homeE,contact,"Home",request.getParameter("Home")));
        emailService.saveChanges(new Email(workE,contact,"Work", request.getParameter("Work")));
        contactService.saveChanges(contact);
        return "redirect:/chooseOption";
    }*/

}
