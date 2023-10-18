<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>LOGIN INFO</legend>
<form action="./createAccount" method="post">
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
<input type="submit" value="CREATE ACCOUNT">

</form>
</fieldset>
</body>
</html>