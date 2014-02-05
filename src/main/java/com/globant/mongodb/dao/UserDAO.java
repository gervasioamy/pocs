package com.globant.mongodb.dao;

import com.globant.mongodb.model.User;

public interface UserDAO {

	// save
	public abstract void createUser(String username, String pwd);

	// find by username
	public abstract User findUser(String username);

	// update password
	public abstract void updateUserPwd(String username, String newPwd);

	// delete by username
	public abstract void deleteUser(String username);

}