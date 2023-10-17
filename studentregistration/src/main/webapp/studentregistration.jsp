<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Registration Form </title>
</head>
<body>

<%  
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String contact = request.getParameter("contact");
    String address = request.getParameter("address");
    String gender = request.getParameter("gender");
    
    String driverPath = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/weja2";
    String user = "root";
    String password = "root";
    
    try {
      Class.forName(driverPath);
      
      Connection connection = DriverManager.getConnection(dburl, user, password);
      String query = "insert into studentregistration (name, email, contact, address , gender ) values (?, ?, ?, ?, ?)";
      
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, name);
      statement.setString(2, email);
      statement.setString(3, contact);
      statement.setString(4, address);
      statement.setString(5, gender);

      
      int rowsInserted = statement.executeUpdate();
      
      if (rowsInserted != 0) {
        out.println("<h1> Registration Sucessful </h1>");
      } else {
        out.println("<h1> Registration Failed </h1>");
      }
      connection.close();
      statement.close();
    } catch(Exception e) {
      e.printStackTrace();
      out.println("<h1> Registration failed. Please try again. </h1>");
    }

%>

</body>
</html>