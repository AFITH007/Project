package com.niit.PokemartFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
/*	@RequestMapping("/")
	public String home()
	{
		return "index";
	}*/

	@RequestMapping("/about")
	public String aboutus()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/contact")
	public String contactus()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "signup";
	}
	/*@RequestMapping(value="success",method = RequestMethod.POST)
	{
		return "login";
    }
	*/


}
