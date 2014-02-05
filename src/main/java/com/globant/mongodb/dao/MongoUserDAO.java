package com.globant.mongodb.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.globant.mongodb.model.User;

public class MongoUserDAO implements UserDAO {

	private MongoOperations mongoOperations;

	// save
	/* (non-Javadoc)
	 * @see com.globant.mongodb.dao.UserDAO#createUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void createUser(String username, String pwd) {
		User user = new User(username, pwd);
		mongoOperations.save(user);
	}

	// find by username
	/* (non-Javadoc)
	 * @see com.globant.mongodb.dao.UserDAO#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String username) {
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is(username));
		// find the saved user.
		User savedUser = mongoOperations.findOne(searchUserQuery, User.class);
		return savedUser;
	}

	// update password
	/* (non-Javadoc)
	 * @see com.globant.mongodb.dao.UserDAO#updateUserPwd(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateUserPwd(String username, String newPwd) {
		Query searchUserQuery = new Query(Criteria.where("username").is(username));
		mongoOperations.updateFirst(searchUserQuery, Update.update("password", newPwd), User.class);
	}
	
	// delete by username
	/* (non-Javadoc)
	 * @see com.globant.mongodb.dao.UserDAO#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String username) {
		Query searchUserQuery = new Query(Criteria.where("username").is(username));
		mongoOperations.remove(searchUserQuery, User.class);
	}

	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	

}

