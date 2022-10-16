package com.Restaurant;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.RestaurantEncapsulation;
import com.bean.RestaurantBean;
//public class DammyServelt {
	//@WebServlet("/DammyServelt")
	public class RestaurantServelt extends HttpServlet{

	/**
		 * 
		 */
		private static final long serialVersionUID = 5441633904037668389L;
	public RestaurantServelt() {
	super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("form submitted on GET");
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
	int result = we.insertstatement(es);
	HttpSession session = request.getSession();
	session.setAttribute("MenuObject", es);

	RequestDispatcher empservlet = request.getRequestDispatcher("/Restaurantdata");
	RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
	if(result>0) {
	empservlet.forward(request, response);
	} else {
	failure.forward(request, response);
	}
	
	}

	}

