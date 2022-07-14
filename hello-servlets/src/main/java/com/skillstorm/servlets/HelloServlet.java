package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//first thing to do is map all requests coming into servlet
//@WebServlet(urlPatterns = "/my-servlet")
public class HelloServlet extends HttpServlet{
	//CRUD applies here
	//HTTP request
	//GET /my-servlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//incoming request
		//outgoing response
		System.out.println("Im a java");
		resp.getWriter().append("Hello Client"); // appends data to http response body
	}
	
	//POST /my-servlet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("pickle"));
		//resp.sendRedirect("success.html");
		req.getRequestDispatcher("success.html").forward(req, resp);
	}
	
	//UPDATE => doPut
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	//DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
