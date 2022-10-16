package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RestaurantBean;
import com.bean.RestaurantEncapsulation;



public class fetchservelt extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1571811801014856573L;
	public fetchservelt() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		RestaurantBean dao = new RestaurantBean();
		List<RestaurantEncapsulation> result = dao.Fetch();

		HttpSession session = request.getSession();
		session.setAttribute("Object", result);

		RequestDispatcher req = request.getRequestDispatcher("view.jsp");
		req.forward(request, response);
		}
}