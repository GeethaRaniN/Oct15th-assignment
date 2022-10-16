package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RestaurantEncapsulation;



public class menuservlet extends HttpServlet{


/**
	 * 
	 */
	private static final long serialVersionUID = -3435847531707896476L;

public menuservlet() {
super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");

HttpSession session = request.getSession();
Object obj =session.getAttribute("MenuObject");
RestaurantEncapsulation RE = null;
if(obj!=null) {
RE = (RestaurantEncapsulation)obj;
}
PrintWriter out = response.getWriter();
out.print("<html><body>");
out.print("<p>Name</p>");
out.print("<p>"+RE.getName()+"</p>");
out.print("<p>Soups</p>");
out.print("<p>"+RE.getSoups()+"</p>");
out.print("<p>Starters</p>");
out.print("<p>"+RE.getStarters()+"</p>");
out.print("<p>MainCourse</p>");
out.print("<p>"+RE.getMainCourse()+"</p>");
out.print("<p>Desserts</p>");
out.print("<p>"+RE.getDesserts()+"</p>");
out.print("<p>Mocktails</p>");
out.print("<p>"+RE.getMocktails()+"</p>");

out.print("<button>");
out.print("<a href='index.html'>Home Page</a>");
out.print("</button>");
out.print("</body></html>");
}
}