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
import org.springframework.web.bind.annotation.RequestParam;
import service.ContactService;
import service.EmailService;
import service.PhoneService;

import java.util.List;
import java.util.Locale;

/**
 * Created by Yevgeni on 28.01.2016.
 */
//@Path("/")
@Controller
public class MainController {
    // SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    @Autowired
    private ContactService contactService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale) {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String ToIndex() {
        System.out.print("goToIndex");
        return "index";
    }

    @RequestMapping(value = "/showContactList", method = RequestMethod.GET)
    private String goToShowContactList(Model model) {
        List<Contact> conList = contactService.getAllContact();
        model.addAttribute("conList", conList);
        return "showContactList";
    }
    @RequestMapping(value = "/showContactList/{contactId}",method = RequestMethod.GET)
    private String moreInformContact(Model model, @PathVariable("contactId") Integer id,Locale locale) {
        Contact contact=contactService.getContact(id);
        List<Email> emails=emailService.getContactEmails(id);
        List<Phone> phones=phoneService.getContactPhones(id);
        model.addAttribute("contact",contact);
        model.addAttribute("emails",emails);
        model.addAttribute("phones",phones);
        return "contactInform";
    }
    @RequestMapping(value = "/chooseOption", method = RequestMethod.GET)
    private String goToChooseOperation(Model model) {
        List<Contact> conList = contactService.getAllContact();
        model.addAttribute("conList", conList);
        return "chooseOption";
    }
}
