package com.lti.model.dao;

import java.util.List;

import com.lti.model.beans.User;

public interface UserDao {
	public int store(User user);

	public User login(int id, String password);

	public List<User> getAllUsers();

	public User changePassword(int id, String oldPassword, String newPassword);
}
