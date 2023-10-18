<%@page import="com.jspiders.cardekhocasestudyspringmvc.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<%
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
%>
<%
CarPOJO car = (CarPOJO) request.getAttribute("car");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if (car == null) {
	%>
	<fieldset>
		<legend>UPDATE CAR</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>


			</table>
			<input type="submit" value="SUBMIT">
		</form>
	</fieldset>


	<%
	} else {
	%>
	<fieldset>
		<legend>Update Student</legend>
		<form action="./updateCar" method="post">
			<table id="data">
				<tr>
					<td>ID</td>
					<td><%=car.getId()%></td>
					<td><input type="text" name="id" value="<%=car.getId()%>"
						hidden="true"></td>
				</tr>

				<tr>
					<td>CAR NAME</td>
					<td><input type="text" name="name" value="<%=car.getName()%>"></td>
				</tr>

				<tr>
					<td>CAR BRAND</td>
					<td><input type="text" name="brand"
						value="<%=car.getBrand()%>"></td>
				</tr>

				<tr>
					<td>FUEL TYPE</td>
					<td><input type="text" name="fuelType"
						value="<%=car.getFuelType()%>"></td>
				</tr>

				<tr>
					<td>PRICE</td>
					<td><input type="text" name="price"
						value="<%=car.getPrice()%>"></td>
				</tr>

			</table>
			<input type="submit" value="UPDATE">
		</form>

	</fieldset>

	<%
	}
	%>



	<%
	if (msg != null) {
	%>
	<%=msg%>
	<%
	}
	%>

	<%
	if (cars != null) {
	%>
	<fieldset>
		<legend>CARS DETAILS</legend>
		<table>
			<tr>
				<td>ID</td>
				<td>CAR NAME</td>

				<td>CAR BRAND</td>

				<td>FUELTYPE</td>
				<td>PRICE</td>

			</tr>

			<%
			for (CarPOJO pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>

				<td><%=pojo.getBrand()%></td>

				<td><%=pojo.getFuelType()%></td>

				<td><%=pojo.getPrice()%></td>

			</tr>

			<%
			}
			}
			%>
		</table>
	</fieldset>

</body>
</html>