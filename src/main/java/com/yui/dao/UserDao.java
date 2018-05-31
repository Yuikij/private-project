package com.yui.dao;

import java.util.List;

import com.yui.model.User;



public interface UserDao {
	public User findById(Integer id);
	
	public User save(User user);
			
	public User findByAccount (String account);
	
	public List<User> getAll();
	
	
	
	
	
	
	
}
