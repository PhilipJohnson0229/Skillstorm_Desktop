package com.skillstorm.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.EmployeeDao;
import com.skillstorm.model.Employee;


//controller glues model to the view
@WebServlet(urlPatterns = "/my-servlet")
public class ExpenseServlet extends HttpServlet { // IS-A servlet(polymorphism)

	//INSTANCE VARIABLES ARE NOT THREAD SAFE
	//so we need to make sure what it's DOING IS thread safe
	private EmployeeDao expenseDao = new EmployeeDao();
	
	//HTTP request
	//the servelt class gives us CRUD methods
	//GET / my-servlet(url) / java version
	@Override
	public void init() throws ServletException {
		System.out.println("Hello, this is the init() method");
	}
	
	@Override
	public void destroy() {
		System.out.println("Goodbye, this is the destroy() method");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("Im in java");
		resp.getWriter().append("Hello there dude");
		/*FINAL CODE
		//the firsgt time the user gets on we will store a cookie to maintain state
		Cookie cookie = new Cookie("dan","pickles");
		//adding the cookie to the response
		resp.addCookie(cookie);
		
		if(req.getSession().getAttribute("addedItem") != null) 
		{
			
			System.out.println(req.getSession().getAttribute("addedItem"));
		}
		
		String param = req.getParameter("id"); //query parameter
		resp.setContentType("application/json");
		String json = "";
		if(param != null) 
		{
			int id = Integer.parseInt(param);
			System.out.println(id);
			//take this and add it to my JDBC query
			
			ObjectMapper om = new ObjectMapper();
			
			json = om.writeValueAsString(expenseDao.findAll().get(id));
		}else
		{
			ObjectMapper objectMapper = new ObjectMapper();
			//this is how we will gather our json objects
			json = objectMapper.writeValueAsString(expenseDao.findAll());
		}
		
		//we will have the objectMapper print out the JSONobjects into java string objects
		resp.getWriter().println(json);*/
	}
	
	//POST 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//FINAL CODE
		//print the input from the form with the postTest param
		//System.out.println(req.getParameter("postTest"));
		
		//redirect to another page
		//resp.sendRedirect("response.html");
		//req.getRequestDispatcher("response.html").forward(req, resp); // writes to the response body
		/*
		//lets get our cookies
		//this will retrun an array of cookies
		if(req.getCookies() != null) {
			for(Cookie cookie : req.getCookies()) 
			{
				if(cookie.getName().equals("dan")) 
				{
					System.out.println(cookie.getName() + " has been stored as a cookie");
				}
			}
		}

		//http GET request body will send json for this servlet to parse.  we need the line below
		InputStream requestBody = req.getInputStream();
		
		//in order to use
		ObjectMapper objectMapper = new ObjectMapper();
		
		//this takes the input stream and parses the json into a java object
		Employee employee = objectMapper.readValue(requestBody, Employee.class); //takes inputstream and converts to object
		
		expenseDao.add(employee);
		
		//this is how we maintain state with our API
		//this looks for the JSESSIONID cookie
		//so amazingly java objects are serializable going across the wire
		req.getSession().setAttribute("addedItem", employee);
		
		resp.setStatus(201);*/
	}
	
	//UPDATE
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	//DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
