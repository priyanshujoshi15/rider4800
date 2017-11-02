package com.Dao;

import java.util.List;

import com.model.*;

public interface UserDao 
{
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();
}
