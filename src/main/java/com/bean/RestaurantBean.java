package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantBean {
Connection connect;
Statement State;
ResultSet resultset;
PreparedStatement ps;
public RestaurantBean () {
	connect= DBConnection.getInstance();
}
public int insertstatement(RestaurantEncapsulation RE) {
	int result = 0;
	try {
		
	String query="insert into menu values(?,?,?,?,?,?)";
	ps = connect.prepareStatement(query);
	ps.setString(1,RE.getName());
	ps.setString(2, RE.getSoups());
	ps.setString(3, RE.getStarters());
	ps.setString(4, RE.getMainCourse());
	ps.setString(5, RE.getDesserts());
	ps.setString(6, RE.getMocktails());
	
	result= ps.executeUpdate();
}
catch (SQLException E) {
	E.printStackTrace();}
return result;

}
	
public int Updatedata(RestaurantEncapsulation RE) {
	int result =0;
try {
	
	String query="update menu set Soups =?, Starters = ?, MainCourse = ?, Desserts = ?, Mocktails = ? where Name = ?";
	ps = connect.prepareStatement(query);
	
	ps.setString(1, RE.getSoups());
	ps.setString(2, RE.getStarters());
	ps.setString(3, RE.getMainCourse());
	ps.setString(4, RE.getDesserts());
	ps.setString(5, RE.getMocktails());
	ps.setString(6, RE.getName());
	
	result= ps.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
}
return result;
}
public RestaurantEncapsulation Searchdata(String sd) {
	RestaurantEncapsulation result = null;
String query = "select * from menu where Name = ?";
try {
ps = connect.prepareStatement(query);
ps.setString(1,sd);
resultset = ps.executeQuery();
while(resultset.next()) {
result = new RestaurantEncapsulation();
result.setName(resultset.getString(1));
result.setSoups(resultset.getString(2));
result.setStarters(resultset.getString(3));
result.setMainCourse(resultset.getString(4));
result.setDesserts(resultset.getString(5));
result.setMocktails(resultset.getString(6));
}

}

catch (SQLException e) {
e.printStackTrace();
}
return result;
}

public List<RestaurantEncapsulation> Fetch() {
List<RestaurantEncapsulation> listofemp = new ArrayList<RestaurantEncapsulation>();
String query = "select * from menu";
try {
ps = connect.prepareStatement(query);

resultset = ps.executeQuery();
RestaurantEncapsulation result = null;

while(resultset.next()) {
result = new RestaurantEncapsulation();
result.setName(resultset.getString(1));
result.setSoups(resultset.getString(2));
result.setStarters(resultset.getString(3));
result.setMainCourse(resultset.getString(4));
result.setDesserts(resultset.getString(5));
result.setMocktails(resultset.getString(6));

listofemp.add(result);
}

}

catch (SQLException e) {
e.printStackTrace();
}
return listofemp;
}
}
