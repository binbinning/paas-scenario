<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加用户</title>
</head>
<body>
	增加用户 - add user:
	<form action="user" method="post">
		<label id="name">姓名Name:</label> <input type="text" name="name" /> <span
			class="error">${errors.user}</span><br /> <label id="age">年龄Age:</label>
		<input type="text" name="age" /><span class="error">${errors.age}</span>
		<br /> <input type="submit" value="add"> <input type="reset"
			value="cancel">
	</form>
</body>
</html>