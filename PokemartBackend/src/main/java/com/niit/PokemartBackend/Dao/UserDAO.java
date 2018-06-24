package com.niit.PokemartBackend.Dao;

import java.util.List;

import com.niit.PokemartBackend.Model.User;


public interface UserDAO {
	
	
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int user);
	public List<User> getUser();
	public boolean isValidUser(String email, String password);
	public boolean save(User user);


	public User get(String email);
//	User getCustomerByUsername (String username);


}