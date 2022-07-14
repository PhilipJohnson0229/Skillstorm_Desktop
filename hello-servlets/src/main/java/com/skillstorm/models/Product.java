package com.skillstorm.models;

import java.io.Serializable;

//serializable will take the objects info and serialize it into bytes so it can be represented in binary
public class Product implements Serializable{
	private int id;
	private String name;
	private double price;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
