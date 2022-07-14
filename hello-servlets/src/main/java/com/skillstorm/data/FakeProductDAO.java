package com.skillstorm.data;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.skillstorm.models.Product;

public class FakeProductDAO {
	//this is thread safe
	//this will avoid concurrentmodification exception
	//this happens when someone is trying to read when someone is trying to write
	List<Product> data = new CopyOnWriteArrayList<>();
	
	public List<Product> findAll()
	{
		return data;
	}
	
	public void addProduct(Product product)
	{
		data.add(product);
	}
}
