package com.view;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RestaurantEncapsulation;



public class Restaurantdata extends HttpServlet{
	

/**
	 * 
	 */
	private static final long serialVersionUID = -6722907364893472236L;

public Restaurantdata() {
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
RequestDispatcher rd = request.getRequestDispatcher("/menuservlet");
session.setAttribute("Restaurantdata", rd);
PrintWriter out = response.getWriter();
out.print("<html><body><table>");
//out.print("<tr><th>id")
//out.print("<td>"+emp.getid()+"</td>");
out.print("<button>");
out.print("<a href='menuservlet'>Data</a>");
out.print("</button>");
out.print("</table></body></html>");
}
}