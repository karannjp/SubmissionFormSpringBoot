package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	
	@RequestMapping("/")
	public String  CustomerDetails() {
		
		return "customer";
		
	}
	
	@RequestMapping("/details")
	public String  Details(Customers customer) {
		repo.save(customer);
		return "customer";
		
	}
	
	@RequestMapping("/getdetails")
	public String  getDetails() {
		
		return "viewDetails";
		
	}
	
	/*@GetMapping("edureka")
	public String  CustomerDetails() {
		
		return "customer";
		
	}*/
	
@PostMapping("/getDetails_1")
public ModelAndView getdetails(@RequestParam int cid) {
	ModelAndView mv=new ModelAndView("Retrive");
	Customers customers=repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
	
}
	}
