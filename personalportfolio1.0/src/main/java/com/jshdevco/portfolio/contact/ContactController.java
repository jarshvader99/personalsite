package com.jshdevco.portfolio.contact;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ContactController {
	
	@Value("${gmail.username}")
    private String username;
	
	@Value("${gmail.password}")
    private String password;
	
	@Autowired
	ContactEmailService contactEmailService;
	
	@PostMapping("/sendEmail")
    public String createNote(Model model, HttpServletRequest request, @ModelAttribute ContactForm contactForm) {
		
        String name = contactForm.getName();
        String emailBody = contactForm.getEmailBody();
        try {
        	ContactEmailService.main(name, emailBody, username, password);
        	model.addAttribute("succMsg", "Message has successfully sent");
        }
        catch (Exception e) {
			// TODO: handle exception
        	
		}
        
		return "emailSent";
    }
}