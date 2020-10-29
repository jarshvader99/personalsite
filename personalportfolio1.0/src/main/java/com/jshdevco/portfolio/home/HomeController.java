package com.jshdevco.portfolio.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jshdevco.portfolio.contact.ContactForm;

@Controller
public class HomeController {
	
	@Value("${movie.apiKey}")
    private String apiKey;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model, @ModelAttribute ContactForm contactForm) {
        
		String msg = "Hello World!";
        model.addAttribute("msg", msg);
        model.addAttribute("contactForm", contactForm);
        
		return "index";
	}
	
	@RequestMapping("/getPopular")
	public String getPopular(@RequestParam(name="page") String page, HttpServletRequest request, Model model) {
        
        final String uri = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=en-US&page=" + page;
	    RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper mapper = new ObjectMapper();
	    String result = restTemplate.getForObject(uri, String.class);
   	    // convert JSON array to List
	    try 
	    {
			Popular popular = mapper.readValue(result, Popular.class);
			model.addAttribute("popular", popular);
			List<Result> results = new ArrayList<>();
			for(Result detailInResult : popular.getResults())
			{
				results.add(detailInResult);
				model.addAttribute("results", results);
			}
		} 
	    catch (JsonMappingException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    catch (JsonProcessingException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return "popularMovies";
	}
}