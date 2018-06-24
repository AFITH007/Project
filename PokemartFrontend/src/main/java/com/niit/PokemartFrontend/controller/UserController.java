package com.niit.PokemartFrontend.controller;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PokemartBackend.Dao.CategoryDAO;
import com.niit.PokemartBackend.Dao.ProductDAO;
import com.niit.PokemartBackend.Dao.SupplierDao;
import com.niit.PokemartBackend.Dao.UserDAO;
import com.niit.PokemartBackend.Model.Category;
import com.niit.PokemartBackend.Model.Product;
import com.niit.PokemartBackend.Model.Supplier;
import com.niit.PokemartBackend.Model.User;



@Controller
public class UserController {
	
	/*
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDAO;
	
	@Autowired
	Product product;*/
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value="success",method = RequestMethod.POST)
	public String registerUser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,@RequestParam("password")String password,@RequestParam("confirmpassword")String confirmpassword,@RequestParam("phone")String phone)
	{
		User user=new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
        user.setEmail(email);
        user.setMobileNo(phone);
        user.setPassword(password);
        /*user.setConfirmpassword(confirmpassword);*/
  		userDAO.addUser(user);
		return "login";
    }
	
	@RequestMapping("/invalid")
	public String invalid(HttpSession Session)
	{
		Session.setAttribute("ErrorMessage","Invalid Credentials");
		return "index";
	}
	

	
	@RequestMapping("/loginsuccess")
	public String showMessage(@RequestParam(value="email")String name,@RequestParam(value="password")String password, 
			HttpSession session,Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		
		 if (authority.getAuthority().equals(role)) 
	     {
	    	 session.setAttribute("email",email);
			 session.setAttribute("SuccessMessage","Login Successful");
	    	 page="UserHome";
	    	 
	    	 
	    	
	     }
	     else 
	     {
	  
	    page="AdminHome";
	    session.setAttribute("SuccessMessage","Login Successful");
	    	 break;
	    }
		}
		 return page;
		}
	@RequestMapping("/isValidUser")
	public ModelAndView showMessage(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		System.out.println("in controller");

		String message;
		ModelAndView mv ;
		if (userDAO.isValidUser(email,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("product");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("Success");
		}
	
		mv.addObject("message", message);
		mv.addObject("username", email);
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("index");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logoutMessage","you are successfully logged out");
		mv.addObject("loggedOut","true");
		return mv;
	}
		

	
}