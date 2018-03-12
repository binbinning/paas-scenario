/**
 * 
 */
package com.yylm.paas;

import junit.framework.TestCase;

/**
 * @author ningjb
 *
 */
public class UserDaoTest extends TestCase {

	UserService service = new UserDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		service.addUser(new User("Nick", 31));
		service.addUser(new User("Lank", 28));
		service.addUser(new User("Jack", 30));
	}

	/**
	 * Test method for
	 * {@link com.yylm.paas.UserDao#addUser(com.yylm.paas.User)}.
	 */
	public void testAddUser() {
		service.addUser(new User("Tony", 33));
		User user = service.findUserByName("Tony");
		assertEquals("Tony", user.getUsername());
		assertEquals(33, user.getAge());
	}

	/**
	 * Test method for
	 * {@link com.yylm.paas.UserDao#findUserByName(java.lang.String)}.
	 */
	public void testFindUserByName() {
		User user = service.findUserByName("Nick");
		assertEquals("Nick", user.getUsername());
		assertEquals(31, user.getAge());
	}

	/**
	 * Test method for
	 * {@link com.yylm.paas.UserDao#deleteUser(java.lang.String)}.
	 */
	public void testDeleteUser() {
		int initUserCount = service.getUsers().size();
		service.deleteUser("Jack");
		int currentUserCount = service.getUsers().size();
		assertEquals(1, initUserCount - currentUserCount);
	}

}
