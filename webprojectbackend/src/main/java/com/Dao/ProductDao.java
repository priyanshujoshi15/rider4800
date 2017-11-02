package com.Dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	
	public boolean insertProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	
	public Product getProductBypid(int pid);
	
	public List<Product> getAllProducts();
	
}
