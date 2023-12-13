<%@page import="com.jspiders.finalmock.pojo.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%String msg = (String)request.getAttribute("msg"); %>
        <%List<EmployeePOJO> employees = (List<EmployeePOJO>)request.getAttribute("employees"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add Page</h1>

<fieldset>

<form action="./addPage" method="post">
<table>
<tr>
<td>ENTER Name</td>
<td><input required="required" type="text" name="name"></td>

</table>
<input type="submit" value="ADD">
</form>
</fieldset>

<%if(msg != null){ %>
<h1><%=msg %></h1>

<%} %>



<%if(employees != null){ %>

<fieldset>
<legend>Employee DETAILS</legend>
<table id="data">
<tr>
<td>ID</td>
<td>NAME</td>
</tr>

<%for(EmployeePOJO pojo:employees){ %>
<tr>
<td><%=pojo.getId() %></td>
<td><%=pojo.getName() %></td>
</tr>

<%} %>

<%} %>

</body>
</html>