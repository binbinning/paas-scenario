package com.yylm.paas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * very simple impl
 * 
 * @author ningjb
 *
 */
public class UserDao implements UserService {

	// 内存实现
	private Map<String, User> users = new HashMap<String, User>();

	@Override
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}

	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		Iterator<User> itr = users.values().iterator();
		while (itr.hasNext()) {
			list.add(itr.next());
		}
		return list;
	}

	@Override
	public User findUserByName(String username) {
		return users.get(username);
	}

	@Override
	public void deleteUser(String userName) {
		users.remove(userName);
	}

}
