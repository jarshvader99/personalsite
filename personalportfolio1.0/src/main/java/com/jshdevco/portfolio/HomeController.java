package com.jshdevco.portfolio;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model) {
        
		String msg = "Hello World!";
        model.addAttribute("msg", msg);
        
		return "index";
	}
	
}