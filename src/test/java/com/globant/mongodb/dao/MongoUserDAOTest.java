package com.globant.mongodb.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.globant.mongodb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/SpringConfig.xml")
public class MongoUserDAOTest {

	@Autowired
	private UserDAO dao;
	
	@Test
	public void testCreateUser() {
		dao.createUser("gamy1", "pwd123");
		User user = dao.findUser("gamy1");
		Assert.assertNotNull(user);
		Assert.assertEquals("gamy1", user.getUsername());
	}
	
	@Test
	public void testCreateUserWithAddress() {
		dao.createUser("gamy2", "pwd123", "Fake St 123", "99000", "Springfield", "Who Knows");
		User user = dao.findUser("gamy2");
		Assert.assertNotNull(user.getAddress());
		Assert.assertEquals("gamy2", user.getUsername());
	}
	
	@Test
	public void testDeleteUser() {
		dao.deleteUser("gamy1");
		dao.deleteUser("gamy2");
	}
		
}
