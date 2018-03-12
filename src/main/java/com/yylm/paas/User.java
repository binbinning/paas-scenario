package com.yylm.paas;

import java.io.Serializable;

/**
 * User module
 * 
 * @author ningjb
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2382936718775851771L;

	private String username;
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}

}
