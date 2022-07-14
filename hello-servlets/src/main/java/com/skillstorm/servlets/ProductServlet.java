package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.FakeProductDAO;
import com.skillstorm.models.Product;

//controller glues the model to the view
//@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet{

	//unsafe because all threads can access this instance variable
	@Override
	public void init() throws ServletException
	{
		System.out.println("init()");
	}
	
	@Override
	public void destroy()
	{ 
		System.out.println("destroy()");
	}
	private FakeProductDAO dao = new FakeProductDAO(); 
	
	//all of the local variables inside this method are thread safe
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("dan", "pickles");
		resp.addCookie(cookie);
		if(req.getSession().getAttribute("added item") != null) 
		{
			System.out.println(req.getSession().getAttribute("added item"));
		}
		
		String param = req.getParameter("id");
		ObjectMapper objectMapper= new ObjectMapper();
		String json = null;
		resp.setContentType("application/json");
		if(param != null) 
		{
			int index = Integer.parseInt(param);			
			json = objectMapper.writeValueAsString(dao.findAll().get(index));			
		}else 
		{
			json = objectMapper.writeValueAsString(dao.findAll());				
		}
		
		resp.getWriter().println(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		for(Cookie cookie : req.getCookies())
		{
			if(cookie.getName().equals("dan")) 
			{
				System.out.println("Found cookie " + cookie.getValue());
			}
		}
		
		InputStream requestBody = req.getInputStream(); //binary stream of data that we get from HTTP
		ObjectMapper objectMapper= new ObjectMapper();
		//takes input stream and converts it into a product by parsing JSON
		
		Product product = objectMapper.readValue(requestBody, Product.class);
		dao.addProduct(product);
		
		System.out.println("Products: " + product);
		System.out.println("something as changed on my end to make this work");
		//codes
		//200 is great
		//201 created ok(post= unsafe), (get = safe), (delete = unsafe)
		req.getSession().setAttribute("added item", product);
		resp.setStatus(201);
		
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
