package com.niit.PokemartBackend.Dao;

import java.util.List;
import com.niit.PokemartBackend.Model.CartItem;
public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getCartItems(String email);
}