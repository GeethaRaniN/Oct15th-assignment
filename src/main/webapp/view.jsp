<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bean.RestaurantEncapsulation"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurantdata</title>
</head>
<body>
<h2 align ="center">Restaurantdata</h2>
<table align="center">
<%
Object sessionObj = session.getAttribute("Object");
if (sessionObj == null){
out.print("No Data Found");
} else {
List<RestaurantEncapsulation> elist = (ArrayList<RestaurantEncapsulation>)sessionObj;
%>
<tr>
<th>Name</th>
<th>Soups</th>
<th>Starters</th>
<th>MainCourse</th>
<th>Desserts</th>
<th>Mocktails</th>
</tr>
<%
for(RestaurantEncapsulation e : elist){
%>
<tr>
<td><%= e.getName()%></td>
<td><%= e.getSoups()%></td>
<td><%= e.getStarters()%></td>
<td><%= e.getMainCourse()%></td>
<td><%= e.getDesserts()%></td>
<td><%= e.getMocktails()%></td>

<%
}
}
%>
<tr>
<td><button>
<a href="index.html">index</a></button></td>
</tr>
</table>
</body>
</html>



