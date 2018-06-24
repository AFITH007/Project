package com.niit.PokemartFrontend.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.PokemartBackend.Dao.CartItemDAO;
import com.niit.PokemartBackend.Dao.ProductDAO;
import com.niit.PokemartBackend.Dao.UserDAO;
import com.niit.PokemartBackend.Model.CartItem;
import com.niit.PokemartBackend.Model.Product;

@Controller
public class CartController {

	UserDAO userDAO;
	@Autowired
	CartItemDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session, Model m)
		{
			CartItem cartItem=new CartItem();
			Product product=productDAO.getProduct(productId);
			
			String email=(String)session.getAttribute("email");
			cartItem.setProductId(productId);
			cartItem.setQuantity(quantity);
			cartItem.getCartItemId();
		    cartItem.setCartId(1);
			cartItem.setEmail(email);
			cartItem.setPaymentStatus("NP");
			cartItem.setSubtotal(quantity*product.getPrice());
		
			cartDAO.addCartItem(cartItem);
			
			m.addAttribute("cartList",cartDAO.getCartItems(email));
			
			return "Cart";
			
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, @RequestParam("qty")int quantity,HttpSession session,Model m)
	{
		 CartItem cartItem=cartDAO.getCartItem(cartItemId);
		 Product product=productDAO.getProduct(cartItem.getProductId());
	     
	     cartItem.setQuantity(quantity);
	     cartItem.setSubtotal(quantity*product.getPrice());
	     cartDAO.updateCartItem(cartItem);
	     String email= (String)session.getAttribute("username");
		 List<CartItem> listCartItems= cartDAO.getCartItems(email);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     return "Cart";
		
    }
    
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, HttpSession session,Model m)
	{
	     CartItem cartItem=cartDAO.getCartItem(cartItemId);
	     
	     
	     cartDAO.deleteCartItem(cartItem);
	     
	     String email=(String)session.getAttribute("username");
	     List<CartItem> listCartItems= cartDAO.getCartItems(email);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     
		 return "Cart";
		
    }
	
	public int grandTotal(List<CartItem> listCartItems)
	{
		int grandTotal=0;
		for(CartItem cartItem: listCartItems)
		{
			grandTotal=grandTotal+cartItem.getQuantity()*(productDAO.getProduct(cartItem.getProductId()).getPrice());
			
		}
		return grandTotal;
	}
}