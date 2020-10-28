package com.jshdevco.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
public class Application {
	
	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model) {
        
		String msg = "Hello World!";
        model.addAttribute("msg", msg);
        
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
