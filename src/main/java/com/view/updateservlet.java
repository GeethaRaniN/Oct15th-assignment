package com.view;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RestaurantBean;
import com.bean.RestaurantEncapsulation;



public class updateservlet extends HttpServlet{


/**
	 * 
	 */
	private static final long serialVersionUID = -4330320060283352196L;

public updateservlet() {
super();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("form submitted on Post");
	
	RestaurantEncapsulation ec = new RestaurantEncapsulation();
	String menuname = request.getParameter("Name");
	String menusoup = request.getParameter("Soups");
	String menustarters = request.getParameter("Starters");
	String menumaincourse = request.getParameter("MainCourse");
	String menudesserts = request.getParameter("Desserts");
	String menumocktails = request.getParameter("Mocktails");
	
	
	RestaurantEncapsulation es = new RestaurantEncapsulation();
	es.setName(menuname);
	es.setSoups(menusoup);
	es.setStarters(menustarters);
	es.setMainCourse(menumaincourse);
	es.setDesserts(menudesserts);
	es.setMocktails(menumocktails);

		RestaurantBean we = new RestaurantBean();
		int result = we.Updatedata(es);
		HttpSession session = request.getSession();
		session.setAttribute("MenuObject", es);

		RequestDispatcher empservlet = request.getRequestDispatcher("/Restaurantdata");
		RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
		if(result>0) {
		empservlet.forward(request, response);
		} else {
		failure.forward(request, response);
		}
}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form submitted on Get");
		
		String menuname = request.getParameter("Name");
		RestaurantEncapsulation ec = new RestaurantEncapsulation();
		
		RestaurantBean wi = new RestaurantBean();
		RestaurantEncapsulation result = wi.Searchdata(menuname);
		HttpSession session = request.getSession();
		session.setAttribute("MenuObject", result);

		RequestDispatcher empservlet = request.getRequestDispatcher("/Restaurantdata");
		RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
		if(result !=null) {
		empservlet.forward(request, response);
		} else {
		failure.forward(request, response);
		}
}
}