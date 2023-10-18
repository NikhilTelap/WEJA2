<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>LOGIN</legend>
<form action="./login" method="post">
<table>
<tr>
<td>Username</td>
<td><input type="text" name="username"></td>

</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>

</tr>

</table>
<Input type="submit" value="LOGIN">
</form>
</fieldset>

<%if(msg != null){ %>
<h1><%=msg %></h1>
<%} %>

<a href="http://localhost:8080/cardekhocasestudyspringmvc/createAccount">CREATE ACCOUNT</a>
</body>
</html>