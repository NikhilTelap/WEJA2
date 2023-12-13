<%@page import="com.jspiders.finalmock.pojo.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%List<EmployeePOJO> employees = (List<EmployeePOJO>)request.getAttribute("employees"); %>
    		        <%String msg = (String)request.getAttribute("msg"); %>
    		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>

<form action="./searchPage" method="post">
<table>
<tr>
<td>Pattern</td>
<td><input required="required" type="text" name="pattern"></td>

</table>
<input type="submit" value="SEARCH">
</form>
</fieldset>

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

<%if(msg != null){ %>
<h1><%=msg %></h1>

<%} %>

</body>
</html>