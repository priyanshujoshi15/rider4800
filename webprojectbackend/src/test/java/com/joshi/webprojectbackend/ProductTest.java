package com.joshi.webprojectbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.ProductDao;
import com.model.Product;

public class ProductTest 
{

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		Product product = (Product)context.getBean("product");
		
		/*product.setPid(101);
		product.setPname("Burger");
		product.setDescription("Burger of McD @ Discount 50%");
		product.setPrice(400);
		product.setStock(50);
		
		product.setPid(102);
		product.setPname("Pizza");
		product.setDescription("Pizaa of Domino @ Discount 70%");
		product.setPrice(500);
		product.setStock(40);*/
		
		ProductDao dao = (ProductDao)context.getBean("productDao");
		//dao.insertProduct(product);
		
		Product prod = dao.getProductBypid(102);
		//System.out.println(prod.getPname() + " : " + prod.getDescription());
		
		dao.deleteProduct(prod);
		
		//prod.setPname("PIZZACHINO");
		//dao.updateProduct(prod);
		
		
		
		
		
		context.close();
		
	}
}
