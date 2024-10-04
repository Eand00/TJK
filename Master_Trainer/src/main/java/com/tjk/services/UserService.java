package com.tjk.services;

import java.util.Optional;

import com.tjk.entities.User;

public interface UserService {

	public User createUser(User user);
	public User updateUser(Integer id, User updatedUser);
	public void deleteUser(Integer id);
	public User getUserByUsername(String username); //remember to check if the user is set to public if private give a back a user with just username
	public boolean isPasswordStrong(String password);
	public User getUserById(Integer id);
}
