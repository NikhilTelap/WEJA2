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
<legend>ADD CAR DETAILS</legend>
<form action="./add" method="post">

<table>
<tr>
<td>Car Name:</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>Car Brand</td>
<td><input type="text" name="brand"></td>
</tr>


<tr>
<td>Fuel Type</td>
<td><input type="text" name="fuelType"></td>
</tr>


<tr>
<td>Price</td>
<td><input type="text" name="price"></td>
</tr>



</table>

<input type="submit" value="ADD CAR">
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
<td><%=pojo.getId() %></td>
<td><%=pojo.getName()%></td>

<td><%=pojo.getBrand()%></td>

<td><%=pojo.getFuelType()%></td>

<td><%=pojo.getPrice()%></td>

</tr>

<%} %>
</table>

</fieldset>

<%} %>
</body>
</html>