package com.yylm.paas;

import java.util.List;

/**
 * user service interface
 * 
 * @author ningjb
 *
 */
public interface UserService {

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * 根据用户名查找用户
	 * 
	 * @return
	 */
	public User findUserByName(String userName);

	/**
	 * 删除用户
	 * 
	 * @param userName
	 * @return
	 */
	public void deleteUser(String userName);
}
