<%@page import="com.jspiders.cardekhocasestudyspringmvc.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="NavBar.jsp"/>
    <%String msg = (String)request.getAttribute("msg"); %>
    <%List<CarPOJO> cars = (List<CarPOJO>)request.getAttribute("cars");%>
    <%CarPOJO car =(CarPOJO)request.getAttribute("car"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>SEARCH CAR</legend>
<form action="./search" method="post">
<table>
<tr>
<td>Enter ID</td>
<td><input type="text" name="id"></td>
</tr>


</table>
<input type="submit" value="SEARCH">
</form>
</fieldset>

<%if(msg != null){ %>
<%=msg %>
<%} %>

<%if(car != null){ %>
<fieldset>
<legend>CAR DETAILS</legend>
<table>
<tr>
<td>ID</td>
<td>CAR NAME</td>

<td>CAR BRAND</td>

<td>FUELTYPE</td>
<td>PRICE</td>

</tr>

<tr>
<td><%=car.getId()%></td>
<td><%=car.getName()%></td>

<td><%=car.getBrand()%></td>

<td><%=car.getFuelType()%></td>

<td><%=car.getPrice()%></td>

</tr>


</table>
<%} %>
</fieldset>
</body>
</html>