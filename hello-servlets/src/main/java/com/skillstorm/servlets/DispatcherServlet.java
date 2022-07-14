package com.skillstorm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//loadonstartup makes this an EAGERLY loaded servlet
// a /* means give us EVERY url
@WebServlet(urlPatterns = "/*", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read the url and based on that invoke a different handler
		StringBuilder requestURI = new StringBuilder(req.getRequestURI());
		requestURI.replace(0, 16, "");
		String baseURL = requestURI.substring(0, requestURI.indexOf("/"));
		
		System.out.println("GET " + baseURL);
		//map the handlers
		switch(baseURL) 
		{
			case "cart":
			{
				new CartHandler().returnCart();
				break;
			}
			case "customer":
			{
				new CustomerHandler().returnCustomer();
				break;
			}
			default:
			{
				throw new IllegalArgumentException("Handler not mapped");
			}
		}
	}
}

class CartHandler
{
	public void returnCart() 
	{
	System.out.println("cart handler called");
	}	
}

class CustomerHandler
{
	public void returnCustomer() 
	{
		System.out.println("customer handler called");
	}
}
