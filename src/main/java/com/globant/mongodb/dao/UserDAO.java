package com.globant.mongodb.dao;

import com.globant.mongodb.model.User;

/**
 * User DAO
 * 
 * @author gervasio.amy
 */
public interface UserDAO {

	// save
	public abstract void createUser(String username, String pwd);

	public abstract void createUser(String username, String pwd, String address, String zip, String city, String state);

	// find by username
	public abstract User findUser(String username);

	// update password
	public abstract void updateUserPwd(String username, String newPwd);

	// delete by username
	public abstract void deleteUser(String username);

}