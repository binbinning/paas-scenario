<%@page import="com.yylm.paas.*"%>
<%@page import="java.net.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>用户列表</title>
</head>
<body>
	congratulations!!! we have more users:
	<span>${users.size()}</span>
	<br /> add New
	<a href="index.jsp">add user</a>
	<br />
	<c:forEach items="${users}" var="user" varStatus="vs">
		<tr>
			<td><s:property value="#vs.index+1" /></td>
			<td align="center">${user.getUsername()}</td>
			<td align="center">${user.getAge()}</td>
			<a
				href="user?action=delete&username=${URLEncoder.encode(user.getUsername(), "utf-8")}">删除</a>
		</tr>
		<br />
	</c:forEach>
</body>
</html>