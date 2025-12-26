<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Authentication</title>
</head>
<body>

	<%
	
	if(request.getParameter("error")!=null){
	
	%>
	<p style="color: navy;">Invalid Username OR Password</p>
	<%
	}
	%>

	<h1>LOGIN PAGE...</h1>
	<form action="/dologin" method="post">
		<input type="text" name="user" placeholder="Enter UserName"><br>
		<br> <input type="password" name="pass"
			placeholder="Enter Password"><br>
		<br>
		<button>LOGIN</button>
	</form>
</body>
</html>