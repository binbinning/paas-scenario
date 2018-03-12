package com.yylm.paas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/user")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserDao(); // injection

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && !action.isEmpty() && action.equals("delete")) {
			String username = request.getParameter("username");
			System.out.println("delete user with name" + username);
			if (!username.isEmpty()) {
				userService.deleteUser(username);
			}
		}

		request.getSession().setAttribute("users", userService.getUsers());
		request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("name");
		String ageStr = request.getParameter("age");
		System.out.println("processing request with name=" + userName + ", aget=" + ageStr);

		Map<String, String> errors = new HashMap<String, String>();
		if (userName == null || "".equals(userName)) {
			errors.put("user", "用户名不能为空!");
		}

		if (ageStr == null || "".equals(ageStr)) {
			errors.put("age", "age不能为空!");
		}

		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (NumberFormatException nfe) {
			errors.put("age", "必须是数字");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// add user
		User user = new User(userName, age);
		userService.addUser(user);

		request.getSession().setAttribute("users", userService.getUsers());
		request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
	}

}
