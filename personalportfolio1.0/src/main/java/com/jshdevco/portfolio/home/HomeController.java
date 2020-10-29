package com.jshdevco.portfolio.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jshdevco.portfolio.contact.ContactForm;

@Controller
public class HomeController {
	@RequestMapping("/")
		public String home(HttpServletRequest request, Model model, @ModelAttribute ContactForm contactForm) {
	        
			String msg = "Hello World!";
	        model.addAttribute("msg", msg);
	        model.addAttribute("contactForm", contactForm);
	        
			return "index";
		}
}