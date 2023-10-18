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
<legend>REMOVE CAR</legend>
<form action="./remove" method="post">
<table>
<tr>
<td>Enter ID</td>
<td><input type="text" name="id"></td>
</tr>


</table>
<input type="submit" value="REMOVE">
</form>
</fieldset>

<%if(msg != null){ %>
<%=msg %>
<%} %>

<%if(cars != null){ %>
<fieldset>
<legend>CARS DETAILS</legend>
<table id="data">
<tr>
<td>ID</td>
<td>CAR NAME</td>

<td>CAR BRAND</td>

<td>FUELTYPE</td>
<td>PRICE</td>

</tr>

<%for(CarPOJO pojo:cars){ %>
<tr>
<td><%=pojo.getId()%></td>
<td><%=pojo.getName()%></td>

<td><%=pojo.getBrand()%></td>

<td><%=pojo.getFuelType()%></td>

<td><%=pojo.getPrice()%></td>

</tr>

<%} %>
</table>
<%} %>
</fieldset>
</body>
</html>